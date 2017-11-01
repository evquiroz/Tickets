package ctm_people_getinfo_ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputMapping3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputMapping3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getListValues" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ID_Persona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ID_de_inicio_de_sesion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ID_Corporativa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Nombre_s" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Apellido_s" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Puesto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Empresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Organizacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Zona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Grupo_de_Ubicaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Correo_electronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Numero_Local" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputMapping3", propOrder = {
    "getListValues"
})
public class OutputMapping3 {

    @XmlElement(required = true)
    protected List<OutputMapping3 .GetListValues> getListValues;

    /**
     * Gets the value of the getListValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getListValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetListValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputMapping3 .GetListValues }
     * 
     * 
     */
    public List<OutputMapping3 .GetListValues> getGetListValues() {
        if (getListValues == null) {
            getListValues = new ArrayList<OutputMapping3 .GetListValues>();
        }
        return this.getListValues;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ID_Persona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ID_de_inicio_de_sesion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ID_Corporativa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Nombre_s" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Apellido_s" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Puesto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Empresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Organizacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Zona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Grupo_de_Ubicaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Ubicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Correo_electronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Numero_Local" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idPersona",
        "idDeInicioDeSesion",
        "idCorporativa",
        "nombreS",
        "apellidoS",
        "puesto",
        "empresa",
        "organizacion",
        "departamento",
        "zona",
        "grupoDeUbicaciones",
        "ubicacion",
        "correoElectronico",
        "numeroLocal",
        "extension"
    })
    public static class GetListValues {

        @XmlElement(name = "ID_Persona", defaultValue = "PPL")
        protected String idPersona;
        @XmlElement(name = "ID_de_inicio_de_sesion")
        protected String idDeInicioDeSesion;
        @XmlElement(name = "ID_Corporativa")
        protected String idCorporativa;
        @XmlElement(name = "Nombre_s", required = true)
        protected String nombreS;
        @XmlElement(name = "Apellido_s", required = true)
        protected String apellidoS;
        @XmlElement(name = "Puesto")
        protected String puesto;
        @XmlElement(name = "Empresa", required = true)
        protected String empresa;
        @XmlElement(name = "Organizacion")
        protected String organizacion;
        @XmlElement(name = "Departamento")
        protected String departamento;
        @XmlElement(name = "Zona")
        protected String zona;
        @XmlElement(name = "Grupo_de_Ubicaciones")
        protected String grupoDeUbicaciones;
        @XmlElement(name = "Ubicacion")
        protected String ubicacion;
        @XmlElement(name = "Correo_electronico")
        protected String correoElectronico;
        @XmlElement(name = "Numero_Local")
        protected String numeroLocal;
        @XmlElement(name = "Extension")
        protected String extension;

        /**
         * Gets the value of the idPersona property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIDPersona() {
            return idPersona;
        }

        /**
         * Sets the value of the idPersona property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIDPersona(String value) {
            this.idPersona = value;
        }

        /**
         * Gets the value of the idDeInicioDeSesion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIDDeInicioDeSesion() {
            return idDeInicioDeSesion;
        }

        /**
         * Sets the value of the idDeInicioDeSesion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIDDeInicioDeSesion(String value) {
            this.idDeInicioDeSesion = value;
        }

        /**
         * Gets the value of the idCorporativa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIDCorporativa() {
            return idCorporativa;
        }

        /**
         * Sets the value of the idCorporativa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIDCorporativa(String value) {
            this.idCorporativa = value;
        }

        /**
         * Gets the value of the nombreS property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombreS() {
            return nombreS;
        }

        /**
         * Sets the value of the nombreS property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombreS(String value) {
            this.nombreS = value;
        }

        /**
         * Gets the value of the apellidoS property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApellidoS() {
            return apellidoS;
        }

        /**
         * Sets the value of the apellidoS property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApellidoS(String value) {
            this.apellidoS = value;
        }

        /**
         * Gets the value of the puesto property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPuesto() {
            return puesto;
        }

        /**
         * Sets the value of the puesto property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPuesto(String value) {
            this.puesto = value;
        }

        /**
         * Gets the value of the empresa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmpresa() {
            return empresa;
        }

        /**
         * Sets the value of the empresa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmpresa(String value) {
            this.empresa = value;
        }

        /**
         * Gets the value of the organizacion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrganizacion() {
            return organizacion;
        }

        /**
         * Sets the value of the organizacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrganizacion(String value) {
            this.organizacion = value;
        }

        /**
         * Gets the value of the departamento property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDepartamento() {
            return departamento;
        }

        /**
         * Sets the value of the departamento property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDepartamento(String value) {
            this.departamento = value;
        }

        /**
         * Gets the value of the zona property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZona() {
            return zona;
        }

        /**
         * Sets the value of the zona property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZona(String value) {
            this.zona = value;
        }

        /**
         * Gets the value of the grupoDeUbicaciones property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGrupoDeUbicaciones() {
            return grupoDeUbicaciones;
        }

        /**
         * Sets the value of the grupoDeUbicaciones property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGrupoDeUbicaciones(String value) {
            this.grupoDeUbicaciones = value;
        }

        /**
         * Gets the value of the ubicacion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUbicacion() {
            return ubicacion;
        }

        /**
         * Sets the value of the ubicacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUbicacion(String value) {
            this.ubicacion = value;
        }

        /**
         * Gets the value of the correoElectronico property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorreoElectronico() {
            return correoElectronico;
        }

        /**
         * Sets the value of the correoElectronico property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorreoElectronico(String value) {
            this.correoElectronico = value;
        }

        /**
         * Gets the value of the numeroLocal property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroLocal() {
            return numeroLocal;
        }

        /**
         * Sets the value of the numeroLocal property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroLocal(String value) {
            this.numeroLocal = value;
        }

        /**
         * Gets the value of the extension property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExtension() {
            return extension;
        }

        /**
         * Sets the value of the extension property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExtension(String value) {
            this.extension = value;
        }

    }

}
