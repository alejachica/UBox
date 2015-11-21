/**
 * DatosOperadorDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.edu.uniandes.umbrella.ejb;

public class DatosOperadorDTO  implements java.io.Serializable {
    private java.lang.String direccion;

    private java.lang.String email;

    private int idOperador;

    private java.lang.String nit;

    private java.lang.String razonSocial;

    private java.lang.String telefono;

    private java.lang.String urlServicio;

    public DatosOperadorDTO() {
    }

    public DatosOperadorDTO(
           java.lang.String direccion,
           java.lang.String email,
           int idOperador,
           java.lang.String nit,
           java.lang.String razonSocial,
           java.lang.String telefono,
           java.lang.String urlServicio) {
           this.direccion = direccion;
           this.email = email;
           this.idOperador = idOperador;
           this.nit = nit;
           this.razonSocial = razonSocial;
           this.telefono = telefono;
           this.urlServicio = urlServicio;
    }


    /**
     * Gets the direccion value for this DatosOperadorDTO.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this DatosOperadorDTO.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the email value for this DatosOperadorDTO.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this DatosOperadorDTO.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the idOperador value for this DatosOperadorDTO.
     * 
     * @return idOperador
     */
    public int getIdOperador() {
        return idOperador;
    }


    /**
     * Sets the idOperador value for this DatosOperadorDTO.
     * 
     * @param idOperador
     */
    public void setIdOperador(int idOperador) {
        this.idOperador = idOperador;
    }


    /**
     * Gets the nit value for this DatosOperadorDTO.
     * 
     * @return nit
     */
    public java.lang.String getNit() {
        return nit;
    }


    /**
     * Sets the nit value for this DatosOperadorDTO.
     * 
     * @param nit
     */
    public void setNit(java.lang.String nit) {
        this.nit = nit;
    }


    /**
     * Gets the razonSocial value for this DatosOperadorDTO.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this DatosOperadorDTO.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the telefono value for this DatosOperadorDTO.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this DatosOperadorDTO.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the urlServicio value for this DatosOperadorDTO.
     * 
     * @return urlServicio
     */
    public java.lang.String getUrlServicio() {
        return urlServicio;
    }


    /**
     * Sets the urlServicio value for this DatosOperadorDTO.
     * 
     * @param urlServicio
     */
    public void setUrlServicio(java.lang.String urlServicio) {
        this.urlServicio = urlServicio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosOperadorDTO)) return false;
        DatosOperadorDTO other = (DatosOperadorDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.idOperador == other.getIdOperador() &&
            ((this.nit==null && other.getNit()==null) || 
             (this.nit!=null &&
              this.nit.equals(other.getNit()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.urlServicio==null && other.getUrlServicio()==null) || 
             (this.urlServicio!=null &&
              this.urlServicio.equals(other.getUrlServicio())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += getIdOperador();
        if (getNit() != null) {
            _hashCode += getNit().hashCode();
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getUrlServicio() != null) {
            _hashCode += getUrlServicio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosOperadorDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ejb.umbrella.uniandes.edu.co/", "datosOperadorDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOperador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idOperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "razonSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
