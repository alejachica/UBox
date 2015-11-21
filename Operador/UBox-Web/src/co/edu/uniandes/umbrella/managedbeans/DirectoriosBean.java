package co.edu.uniandes.umbrella.managedbeans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
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
import co.edu.uniandes.umbrella.entidades.FormaComparticion;
import co.edu.uniandes.umbrella.entidades.ListaValor;
import co.edu.uniandes.umbrella.entidades.ListaValoresEnum;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;
import co.edu.uniandes.umbrella.interfaces.FormaComparticionEJBLocal;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBLocal;

@ManagedBean(name="directorioBean")
@ViewScoped
public class DirectoriosBean extends BaseBeanConSesion implements  Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7143308144394007334L;

	//------------------ATRIBUTOS------------------//
	
	@EJB
	private CarpetaEJBRemote carpetaEJB;
	
	@EJB
	private DocumentosEJBRemote documentoEJB;
	
	@EJB
	private FormaComparticionEJBLocal formaComparticionEJB;
	
	@EJB
	private ListaValorEJBLocal listaValorEJB;
	
	private TreeNode root;
	
	private DataTreeTable elementoSeleccionado;
	
	private String descripcionCarpeta;
	
	private String nombreCarpeta;
	
	private String descripcion;
	
	private String nombre;
	
	private int carpetaId;
	
	private int documentoId;
	
	private UploadedFile file;
	
	private StreamedContent fileDown;
	
	private List<FormaComparticion> listaCompartir;
	
	private int idFormaComparticion;
	
	private List<ListaValor> tiposDocumento;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	private String passDoc;
	
	private String email;
	
	//-------------------METODOS GET Y SET-------------------//

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public String getDescripcionCarpeta() {
		return descripcionCarpeta;
	}

	public void setDescripcionCarpeta(String descripcionCarpeta) {
		this.descripcionCarpeta = descripcionCarpeta;
	}

	public String getNombreCarpeta() {
		return nombreCarpeta;
	}

	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
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
    
	public List<FormaComparticion> getListaCompartir() {
		return listaCompartir;
	}

	public void setListaCompartir(List<FormaComparticion> listaCompartir) {
		this.listaCompartir = listaCompartir;
	}   
	
	public int getIdFormaComparticion() {
		return idFormaComparticion;
	}

	public void setIdFormaComparticion(int idFormaComparticion) {
		this.idFormaComparticion = idFormaComparticion;
	}
	
	public List<ListaValor> getTiposDocumento() {
		return tiposDocumento;
	}

	public void setTiposDocumento(List<ListaValor> tiposDocumento) {
		this.tiposDocumento = tiposDocumento;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public String getPassDoc() {
		return passDoc;
	}

	public void setPassDoc(String passDoc) {
		this.passDoc = passDoc;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//-------------------OTROS METODOS-------------------//

	@PostConstruct
	public void init(){
		root = crearRoot();
		inicializarDatos();
	}
	
	public void inicializarDatos(){
		listaCompartir = formaComparticionEJB.obtenerFormasComparticion();
		tiposDocumento = listaValorEJB.buscarLista(ListaValoresEnum.IDLISTA_TIPOIDENTIFICACION.getValue());
	}
	
	public TreeNode crearRoot(){
		TreeNode root = new DefaultTreeNode(new DataTreeTable(), null);
		try {
			List<CarpetaDTO> carpetas = carpetaEJB.carpetasXUsuario(this.getUsuarioAutenticado().getId());
			for(CarpetaDTO carp: carpetas){
				TreeNode carpeta = new DefaultTreeNode(new DataTreeTable(carp.getIdCarpeta(), carp.getNombreCarpeta(), carp.getDescripcion(), null, "Folder"), root);
				List<DocumentoDTO> docsDTO = documentoEJB.listarDocumentosCarpeta(carp.getIdCarpeta());
				for(DocumentoDTO doc: docsDTO){
					TreeNode docum = new DefaultTreeNode(new DataTreeTable(doc.getIdDocumento(), doc.getNombre(), null, Integer.toString(doc.getSize()), "Archivo"), carpeta);
				}
				crearSubRoot(carpeta, carp.getIdCarpeta());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	public TreeNode crearSubRoot(TreeNode rama, int idCarpeta) throws Exception{
		List<CarpetaDTO> carpetasHijas = carpetaEJB.consultarCarpetasHijas(idCarpeta);
		for(CarpetaDTO carpHijas: carpetasHijas){
			TreeNode carpeta = new DefaultTreeNode(new DataTreeTable(carpHijas.getIdCarpeta(), carpHijas.getNombreCarpeta(), carpHijas.getDescripcion(), null, "Folder"), rama);
			List<DocumentoDTO> docsDTOHijas = documentoEJB.listarDocumentosCarpeta(carpHijas.getIdCarpeta());
			for(DocumentoDTO doc: docsDTOHijas){
				TreeNode docum = new DefaultTreeNode(new DataTreeTable(doc.getIdDocumento(), doc.getNombre(), null, Integer.toString(doc.getSize()), "Archivo"), carpeta);
			}
			carpetasHijas = carpetaEJB.consultarCarpetasHijas(carpHijas.getIdCarpeta());
			if(carpetasHijas!=null)
				crearSubRoot(carpeta, carpHijas.getIdCarpeta());
			else
				return carpeta;
		}
		return rama;
	}
	
	public void crearCarpeta(){
		try{
		CarpetaDTO carpetaDTO = new CarpetaDTO();
		carpetaDTO.setDescripcion(descripcionCarpeta);
		carpetaDTO.setNombreCarpeta(nombreCarpeta);
		if(carpetaEJB.crearCarpeta(carpetaDTO, this.getUsuarioAutenticado().getId())){
			root = crearRoot();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se creo la carpeta correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else
			throw new Exception("Fallo creando carpeta, comuniquese con el administrador");
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void crearsubCarpeta(){
		try{
		CarpetaDTO carpetaDTO = new CarpetaDTO();
		carpetaDTO.setDescripcion(descripcion);
		carpetaDTO.setNombreCarpeta(nombre);
		carpetaDTO.setCarpetaPadre(carpetaId);
		if(carpetaEJB.crearCarpeta(carpetaDTO, this.getUsuarioAutenticado().getId())){
			root = crearRoot();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se creo la sub-carpeta correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else
			throw new Exception("Fallo creando sub-carpeta, comuniquese con el administrador");
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void eliminarCarpeta(){
		try{
			carpetaEJB.eliminarCarpeta(this.carpetaId);
			root = crearRoot();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se elimino la carpeta correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch(EJBException ex){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se puede eliminar la carpeta, primero debe eliminar los elementos asociados que ésta tiene");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
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
	        	documentoDTO.setFkUsuario(this.getUsuarioAutenticado().getId());
	        	//documentoDTO.setIdTipoDocumento(new BigDecimal(1)); TODO seleccionar el tipo adecuado
	        	documentoDTO.setIdTipoMime(file.getContentType());
	        	documentoDTO.setNombre(file.getFileName());
	        	documentoDTO.setPalabrasClave("archivo1");
	        	documentoDTO.setVersion("version1");
	        	documentoDTO.setPapelera(false);
	        	documentoDTO.setSize((int)file.getSize());
	        	if(documentoEJB.crearDocumento(documentoDTO)){
		            FacesMessage message = new FacesMessage("Exito", file.getFileName() + " ha sido cargado.");
		            FacesContext.getCurrentInstance().addMessage(null, message);
		            root = crearRoot();
	        	}
	        	else
	        		throw new Exception("Fallo cargando el documento, comuniquese con el administrador");
	        }
    	}
    	catch(Exception e){
    		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
    	}
    }

	public void eliminarDocumento(){
		try{
			documentoEJB.manejoPapelera(this.documentoId, true);
			root = crearRoot();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se elimino el documento correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
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
	
	public void compartirDocumento(){
		if(idFormaComparticion == 5){
			System.out.println(documentoId);
			System.out.println(this.getUsuarioAutenticado().getId());
			System.out.println(tipoDocumento);
			System.out.println(numeroDocumento);
			System.out.println(passDoc);
			System.out.println(email);
			System.out.println();
			//documentoEJB.compartirDocumentoPorLink(idDocumento, idUsuarioOrigen, identificacionDestino, emailDestino, fechaExpiracion, clave);
		}
		else{
			System.out.println(this.getUsuarioAutenticado().getId());
			System.out.println(tipoDocumento);
			System.out.println(numeroDocumento);
			System.out.println(documentoId);
			System.out.println();
			//documentoEJB.compartirDocumentoInterno(idUsuarioOrigen, idUsuarioDestino, soloLectura, idDocumento, fechaExpiracion);
		}
	}
	
}