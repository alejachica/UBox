/**
 * ConsultarServiciosOperadorUsuarioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario;

public class ConsultarServiciosOperadorUsuarioServiceLocator extends org.apache.axis.client.Service implements org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioService {

    public ConsultarServiciosOperadorUsuarioServiceLocator() {
    }


    public ConsultarServiciosOperadorUsuarioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConsultarServiciosOperadorUsuarioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for consultarServiciosOperadorUsuarioPort
    private java.lang.String consultarServiciosOperadorUsuarioPort_address = "http://172.24.99.240:9080/consultarServiciosOperadorUsuarioService/consultarServiciosOperadorUsuarioPort";

    public java.lang.String getconsultarServiciosOperadorUsuarioPortAddress() {
        return consultarServiciosOperadorUsuarioPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String consultarServiciosOperadorUsuarioPortWSDDServiceName = "consultarServiciosOperadorUsuarioPort";

    public java.lang.String getconsultarServiciosOperadorUsuarioPortWSDDServiceName() {
        return consultarServiciosOperadorUsuarioPortWSDDServiceName;
    }

    public void setconsultarServiciosOperadorUsuarioPortWSDDServiceName(java.lang.String name) {
        consultarServiciosOperadorUsuarioPortWSDDServiceName = name;
    }

    public org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioPortType getconsultarServiciosOperadorUsuarioPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(consultarServiciosOperadorUsuarioPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getconsultarServiciosOperadorUsuarioPort(endpoint);
    }

    public org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioPortType getconsultarServiciosOperadorUsuarioPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioBindingStub _stub = new org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioBindingStub(portAddress, this);
            _stub.setPortName(getconsultarServiciosOperadorUsuarioPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setconsultarServiciosOperadorUsuarioPortEndpointAddress(java.lang.String address) {
        consultarServiciosOperadorUsuarioPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioBindingStub _stub = new org.netbeans.j2ee.wsdl.ConsultarServiciosOperador.UserProcess.consultarServiciosOperadorUsuario.ConsultarServiciosOperadorUsuarioBindingStub(new java.net.URL(consultarServiciosOperadorUsuarioPort_address), this);
                _stub.setPortName(getconsultarServiciosOperadorUsuarioPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("consultarServiciosOperadorUsuarioPort".equals(inputPortName)) {
            return getconsultarServiciosOperadorUsuarioPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://j2ee.netbeans.org/wsdl/ConsultarServiciosOperador/UserProcess/consultarServiciosOperadorUsuario", "consultarServiciosOperadorUsuarioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://j2ee.netbeans.org/wsdl/ConsultarServiciosOperador/UserProcess/consultarServiciosOperadorUsuario", "consultarServiciosOperadorUsuarioPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("consultarServiciosOperadorUsuarioPort".equals(portName)) {
            setconsultarServiciosOperadorUsuarioPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
