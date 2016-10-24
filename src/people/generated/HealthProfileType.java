//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.10.24 alle 09:39:21 AM CEST 
//


package people.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per healthProfileType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="healthProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthProfileType", propOrder = {
    "lastupdate",
    "weight",
    "height",
    "bmi"
})
public class HealthProfileType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastupdate;
    protected long weight;
    protected long height;
    protected long bmi;

    /**
     * Recupera il valore della proprietà lastupdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastupdate() {
        return lastupdate;
    }

    /**
     * Imposta il valore della proprietà lastupdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastupdate(XMLGregorianCalendar value) {
        this.lastupdate = value;
    }

    /**
     * Recupera il valore della proprietà weight.
     * 
     */
    public long getWeight() {
        return weight;
    }

    /**
     * Imposta il valore della proprietà weight.
     * 
     */
    public void setWeight(long value) {
        this.weight = value;
    }

    /**
     * Recupera il valore della proprietà height.
     * 
     */
    public long getHeight() {
        return height;
    }

    /**
     * Imposta il valore della proprietà height.
     * 
     */
    public void setHeight(long value) {
        this.height = value;
    }

    /**
     * Recupera il valore della proprietà bmi.
     * 
     */
    public long getBmi() {
        return bmi;
    }

    /**
     * Imposta il valore della proprietà bmi.
     * 
     */
    public void setBmi(long value) {
        this.bmi = value;
    }

}
