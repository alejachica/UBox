package co.edu.uniandes.umbrella.managedbeans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.dto.DataTreeTable;
import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

@ManagedBean(name="directorioBean")
@ViewScoped
public class DirectoriosBean extends BaseBeanConSesion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7143308144394007334L;

	//------------------ATRIBUTOS------------------//
	
	@EJB
	private CarpetaEJBRemote carpetaEJB;
	
	@EJB
	private DocumentosEJBRemote documentoEJB;
	
	private TreeNode root;
	
	private DataTreeTable elementoSeleccionado;
	
	private String descripcion;
	
	private String nombre;
	
	private int carpetaId;
	
	private int documentoId;
	
	private UploadedFile file;
	
	private StreamedContent fileDown;
	
	//-------------------METODOS GET Y SET-------------------//

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public DataTreeTable getElementoSeleccionado() {
		return elementoSeleccionado;
	}

	public void setElementoSeleccionado(DataTreeTable elementoSeleccionado) {
		this.elementoSeleccionado = elementoSeleccionado;
	}
	
	public int getCarpetaId() {
		return carpetaId;
	}

	public void setCarpetaId(int carpetaId) {
		this.carpetaId = carpetaId;
	}
	
	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}
	
	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public StreamedContent getFileDown() {
		return fileDown;
	}
	
	//-------------------OTROS METODOS-------------------//

	@PostConstruct
	public void init(){
		root = crearRoot();
	}
	
	public TreeNode crearRoot(){
		TreeNode root = new DefaultTreeNode(new DataTreeTable(), null);
		try {
			List<CarpetaDTO> carpetas = carpetaEJB.carpetasXUsuario(3); //TODO manejo de usuario, quitar id quemado.
			for(CarpetaDTO carp: carpetas){
				TreeNode carpeta = new DefaultTreeNode(new DataTreeTable(carp.getIdCarpeta(), carp.getNombreCarpeta(), carp.getDescripcion(), null, "Folder"), root);
				List<DocumentoDTO> docsDTO = documentoEJB.listarDocumentosCarpeta(carp.getIdCarpeta());
				for(DocumentoDTO doc: docsDTO){
					TreeNode docum = new DefaultTreeNode(new DataTreeTable(doc.getIdDocumento(), doc.getNombre(), null, Integer.toString(doc.getSize()), "Archivo"), carpeta);
				}
				crearSubCarpeta(carpeta, carp.getIdCarpeta());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	public TreeNode crearSubCarpeta(TreeNode rama, int idCarpeta) throws Exception{
		List<CarpetaDTO> carpetasHijas = carpetaEJB.consultarCarpetasHijas(idCarpeta);
		for(CarpetaDTO carpHijas: carpetasHijas){
			TreeNode carpeta = new DefaultTreeNode(new DataTreeTable(carpHijas.getIdCarpeta(), carpHijas.getNombreCarpeta(), carpHijas.getDescripcion(), null, "Folder"), rama);
			List<DocumentoDTO> docsDTOHijas = documentoEJB.listarDocumentosCarpeta(carpHijas.getIdCarpeta());
			for(DocumentoDTO doc: docsDTOHijas){
				TreeNode docum = new DefaultTreeNode(new DataTreeTable(doc.getIdDocumento(), doc.getNombre(), null, Integer.toString(doc.getSize()), "Archivo"), carpeta);
			}
			carpetasHijas = carpetaEJB.consultarCarpetasHijas(carpHijas.getIdCarpeta());
			if(carpetasHijas!=null)
				crearSubCarpeta(carpeta, carpHijas.getIdCarpeta());
			else
				return carpeta;
		}
		return rama;
	}
	
	public void crearCarpeta(){
		try{
		CarpetaDTO carpetaDTO = new CarpetaDTO();
		carpetaDTO.setDescripcion(descripcion);
		carpetaDTO.setNombreCarpeta(nombre);
		carpetaEJB.crearCarpeta(carpetaDTO, 3); //TODO cambiar usuario quemado
		root = crearRoot();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error creando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void crearsubCarpeta(){
		try{
		CarpetaDTO carpetaDTO = new CarpetaDTO();
		carpetaDTO.setDescripcion(descripcion);
		carpetaDTO.setNombreCarpeta(nombre);
		carpetaDTO.setCarpetaPadre(carpetaId);
		carpetaEJB.crearCarpeta(carpetaDTO, 3); //TODO cambiar usuario quemado
		root = crearRoot();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error creando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void eliminarCarpeta(){
		try{
			carpetaEJB.eliminarCarpeta(this.carpetaId);
			root = crearRoot();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void upload() {
    	try{
	        if(file != null) {
	        	DocumentoDTO documentoDTO = new DocumentoDTO();
	        	documentoDTO.setDocumento(file.getContents());
	        	//documentoDTO.setFecha(""); TODO ajustar fecha
	        	documentoDTO.setFirmado(false);
	        	documentoDTO.setFkCarpeta(carpetaId);
	        	documentoDTO.setFkUsuario(3);
	        	//documentoDTO.setIdTipoDocumento(new BigDecimal(1)); TODO seleccionar el tipo adecuado
	        	documentoDTO.setIdTipoMime(file.getContentType());
	        	documentoDTO.setNombre(file.getFileName());
	        	documentoDTO.setPalabrasClave("archivo1");
	        	documentoDTO.setVersion("version1");
	        	documentoDTO.setPapelera(false);
	        	documentoDTO.setSize((int)file.getSize());
	        	documentoEJB.crearDocumento(documentoDTO);
	            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            root = crearRoot();
	        }
    	}
    	catch(Exception e){
    		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
    	}
    }

	public void eliminarDocumento(){
		try{
			documentoEJB.manejoPapelera(this.documentoId, true);
			root = crearRoot();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando documento", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void downLoad() throws IOException {
		DocumentoDTO documento = documentoEJB.consultarDocumento(this.documentoId);
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();  
		response.reset();
		response.setBufferSize(documento.getDocumento().length);  
		response.setContentType("application/octet-stream");  
		response.setHeader("Content-Length", String.valueOf(documento.getDocumento().length));  
		response.setHeader("Content-Disposition", "attachment;filename=\"" + documento.getNombre() + "\"");  
	    BufferedInputStream input = null;  
	    BufferedOutputStream output = null;  
	    try {  
	    	input = new BufferedInputStream(new ByteArrayInputStream(documento.getDocumento()),documento.getDocumento().length);  
	        output = new BufferedOutputStream(response.getOutputStream(),documento.getDocumento().length);  
	        byte[] buffer = new byte[documento.getDocumento().length];  
			int length;  
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);  
			}  
		} 
	    finally {  
			input.close();  
			output.close();  
		}  
		context.responseComplete();  
	}  
	
}