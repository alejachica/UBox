package org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario;

public class ConsultarServiciosOperadorUsuarioPortTypeProxy implements org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioPortType {
  private String _endpoint = null;
  private org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioPortType consultarServiciosOperadorUsuarioPortType = null;
  
  public ConsultarServiciosOperadorUsuarioPortTypeProxy() {
    _initConsultarServiciosOperadorUsuarioPortTypeProxy();
  }
  
  public ConsultarServiciosOperadorUsuarioPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initConsultarServiciosOperadorUsuarioPortTypeProxy();
  }
  
  private void _initConsultarServiciosOperadorUsuarioPortTypeProxy() {
    try {
      consultarServiciosOperadorUsuarioPortType = (new org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioServiceLocator()).getconsultarServiciosOperadorUsuarioPort();
      if (consultarServiciosOperadorUsuarioPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)consultarServiciosOperadorUsuarioPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)consultarServiciosOperadorUsuarioPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (consultarServiciosOperadorUsuarioPortType != null)
      ((javax.xml.rpc.Stub)consultarServiciosOperadorUsuarioPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioPortType getConsultarServiciosOperadorUsuarioPortType() {
    if (consultarServiciosOperadorUsuarioPortType == null)
      _initConsultarServiciosOperadorUsuarioPortTypeProxy();
    return consultarServiciosOperadorUsuarioPortType;
  }
  
  public co.edu.uniandes.umbrella.ejb.DatosOperadorDTO consultarServiciosOperadorUsuarioOperation(java.lang.String tipoDocumento, java.lang.String part2) throws java.rmi.RemoteException{
    if (consultarServiciosOperadorUsuarioPortType == null)
      _initConsultarServiciosOperadorUsuarioPortTypeProxy();
    return consultarServiciosOperadorUsuarioPortType.consultarServiciosOperadorUsuarioOperation(tipoDocumento, part2);
  }
  
  
}