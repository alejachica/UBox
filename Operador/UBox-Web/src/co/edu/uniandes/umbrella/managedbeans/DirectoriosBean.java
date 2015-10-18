/**
 * 
 */
package co.edu.uniandes.umbrella.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.dto.DataTreeTable;
import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

@ManagedBean(name="directorioBean")
@ViewScoped
public class DirectoriosBean {
	
	//-------------------ATRIBUTOS-------------------//
	
	@EJB
	private CarpetaEJBRemote carpeta;
	
	@EJB
	private DocumentosEJBRemote documento;
	
	private TreeNode root;
	
	private DataTreeTable elementoSeleccionado;
	
	private String descripcion;
	
	private String nombre;
	
	private int carpetaId;
	
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
	
	//-------------------OTROS METODOS-------------------//

	@PostConstruct
	public void init(){
		root = crearRoot();
	}
	
	public TreeNode crearRoot(){
		TreeNode root = new DefaultTreeNode(new DataTreeTable(), null);
		try {
			List<CarpetaDTO> carpetas = carpeta.carpetasXUsuario(3); //TODO manejo de usuario, quitar id quemado.
			for(CarpetaDTO carp: carpetas){
				TreeNode carpeta = new DefaultTreeNode(new DataTreeTable(carp.getIdCarpeta(), carp.getNombreCarpeta(), carp.getDescripcion(), null, "Folder"), root);
				List<DocumentoDTO> docsDTO= documento.listarDocumentosCarpeta(carp.getIdCarpeta());
				for(DocumentoDTO doc: docsDTO){
					TreeNode docum = new DefaultTreeNode(new DataTreeTable(doc.getIdDocumento(), doc.getNombre(), null, Integer.toString(doc.getSize()), "Archivo"), carpeta);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	public void crearCarpeta(){
		try{
		CarpetaDTO carpetaDTO = new CarpetaDTO();
		carpetaDTO.setDescripcion(descripcion);
		carpetaDTO.setNombreCarpeta(nombre);
		carpeta.crearCarpeta(carpetaDTO, 3);
		root = crearRoot();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error creando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void eliminarCarpeta(){
		try{
			carpeta.eliminarCarpeta(this.carpetaId);
			root = crearRoot();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

}