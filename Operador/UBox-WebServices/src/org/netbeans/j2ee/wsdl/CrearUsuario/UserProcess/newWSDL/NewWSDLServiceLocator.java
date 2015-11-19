/**
 * NewWSDLServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL;

public class NewWSDLServiceLocator extends org.apache.axis.client.Service implements org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.NewWSDLService {

    public NewWSDLServiceLocator() {
    }


    public NewWSDLServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NewWSDLServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for newWSDLPort
    private java.lang.String newWSDLPort_address = "http://172.24.99.240:9080/crearUsuarioWsdlService/crearUsuarioWsdlPort";

    public java.lang.String getnewWSDLPortAddress() {
        return newWSDLPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String newWSDLPortWSDDServiceName = "newWSDLPort";

    public java.lang.String getnewWSDLPortWSDDServiceName() {
        return newWSDLPortWSDDServiceName;
    }

    public void setnewWSDLPortWSDDServiceName(java.lang.String name) {
        newWSDLPortWSDDServiceName = name;
    }

    public org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPort getnewWSDLPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(newWSDLPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getnewWSDLPort(endpoint);
    }

    public org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPort getnewWSDLPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.NewWSDLBindingStub _stub = new org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.NewWSDLBindingStub(portAddress, this);
            _stub.setPortName(getnewWSDLPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setnewWSDLPortEndpointAddress(java.lang.String address) {
        newWSDLPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPort.class.isAssignableFrom(serviceEndpointInterface)) {
                org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.NewWSDLBindingStub _stub = new org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.NewWSDLBindingStub(new java.net.URL(newWSDLPort_address), this);
                _stub.setPortName(getnewWSDLPortWSDDServiceName());
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
        if ("newWSDLPort".equals(inputPortName)) {
            return getnewWSDLPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://j2ee.netbeans.org/wsdl/CrearUsuario/UserProcess/newWSDL", "newWSDLService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://j2ee.netbeans.org/wsdl/CrearUsuario/UserProcess/newWSDL", "newWSDLPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("newWSDLPort".equals(portName)) {
            setnewWSDLPortEndpointAddress(address);
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
