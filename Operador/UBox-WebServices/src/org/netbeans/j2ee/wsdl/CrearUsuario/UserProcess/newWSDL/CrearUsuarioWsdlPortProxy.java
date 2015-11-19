package org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL;

public class CrearUsuarioWsdlPortProxy implements org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPort {
  private String _endpoint = null;
  private org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPort crearUsuarioWsdlPort = null;
  
  public CrearUsuarioWsdlPortProxy() {
    _initCrearUsuarioWsdlPortProxy();
  }
  
  public CrearUsuarioWsdlPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initCrearUsuarioWsdlPortProxy();
  }
  
  private void _initCrearUsuarioWsdlPortProxy() {
    try {
      crearUsuarioWsdlPort = (new org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.NewWSDLServiceLocator()).getnewWSDLPort();
      if (crearUsuarioWsdlPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)crearUsuarioWsdlPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)crearUsuarioWsdlPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (crearUsuarioWsdlPort != null)
      ((javax.xml.rpc.Stub)crearUsuarioWsdlPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPort getCrearUsuarioWsdlPort() {
    if (crearUsuarioWsdlPort == null)
      _initCrearUsuarioWsdlPortProxy();
    return crearUsuarioWsdlPort;
  }
  
  public java.lang.String usuariosWSDLCrear(co.edu.uniandes.umbrella.ejb.DatosBasicosUsuarioDTO datosUsuario) throws java.rmi.RemoteException{
    if (crearUsuarioWsdlPort == null)
      _initCrearUsuarioWsdlPortProxy();
    return crearUsuarioWsdlPort.usuariosWSDLCrear(datosUsuario);
  }
  
  
}