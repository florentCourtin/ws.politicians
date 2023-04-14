
package com.wspolitician.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wspolitician.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddPolitician_QNAME = new QName("http://www.wsPolitician.com", "addPolitician");
    private final static QName _AddPoliticianResponse_QNAME = new QName("http://www.wsPolitician.com", "addPoliticianResponse");
    private final static QName _DeletePolitician_QNAME = new QName("http://www.wsPolitician.com", "deletePolitician");
    private final static QName _DeletePoliticianResponse_QNAME = new QName("http://www.wsPolitician.com", "deletePoliticianResponse");
    private final static QName _GetAllPoliticians_QNAME = new QName("http://www.wsPolitician.com", "getAllPoliticians");
    private final static QName _GetAllPoliticiansResponse_QNAME = new QName("http://www.wsPolitician.com", "getAllPoliticiansResponse");
    private final static QName _GetPolitician_QNAME = new QName("http://www.wsPolitician.com", "getPolitician");
    private final static QName _GetPoliticianParti_QNAME = new QName("http://www.wsPolitician.com", "getPoliticianParti");
    private final static QName _GetPoliticianPartiResponse_QNAME = new QName("http://www.wsPolitician.com", "getPoliticianPartiResponse");
    private final static QName _GetPoliticianResponse_QNAME = new QName("http://www.wsPolitician.com", "getPoliticianResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wspolitician.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPolitician }
     * 
     */
    public AddPolitician createAddPolitician() {
        return new AddPolitician();
    }

    /**
     * Create an instance of {@link AddPoliticianResponse }
     * 
     */
    public AddPoliticianResponse createAddPoliticianResponse() {
        return new AddPoliticianResponse();
    }

    /**
     * Create an instance of {@link DeletePolitician }
     * 
     */
    public DeletePolitician createDeletePolitician() {
        return new DeletePolitician();
    }

    /**
     * Create an instance of {@link DeletePoliticianResponse }
     * 
     */
    public DeletePoliticianResponse createDeletePoliticianResponse() {
        return new DeletePoliticianResponse();
    }

    /**
     * Create an instance of {@link GetAllPoliticians }
     * 
     */
    public GetAllPoliticians createGetAllPoliticians() {
        return new GetAllPoliticians();
    }

    /**
     * Create an instance of {@link GetAllPoliticiansResponse }
     * 
     */
    public GetAllPoliticiansResponse createGetAllPoliticiansResponse() {
        return new GetAllPoliticiansResponse();
    }

    /**
     * Create an instance of {@link GetPolitician }
     * 
     */
    public GetPolitician createGetPolitician() {
        return new GetPolitician();
    }

    /**
     * Create an instance of {@link GetPoliticianParti }
     * 
     */
    public GetPoliticianParti createGetPoliticianParti() {
        return new GetPoliticianParti();
    }

    /**
     * Create an instance of {@link GetPoliticianPartiResponse }
     * 
     */
    public GetPoliticianPartiResponse createGetPoliticianPartiResponse() {
        return new GetPoliticianPartiResponse();
    }

    /**
     * Create an instance of {@link GetPoliticianResponse }
     * 
     */
    public GetPoliticianResponse createGetPoliticianResponse() {
        return new GetPoliticianResponse();
    }

    /**
     * Create an instance of {@link Politician }
     * 
     */
    public Politician createPolitician() {
        return new Politician();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPolitician }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPolitician }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "addPolitician")
    public JAXBElement<AddPolitician> createAddPolitician(AddPolitician value) {
        return new JAXBElement<AddPolitician>(_AddPolitician_QNAME, AddPolitician.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPoliticianResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPoliticianResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "addPoliticianResponse")
    public JAXBElement<AddPoliticianResponse> createAddPoliticianResponse(AddPoliticianResponse value) {
        return new JAXBElement<AddPoliticianResponse>(_AddPoliticianResponse_QNAME, AddPoliticianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePolitician }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePolitician }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "deletePolitician")
    public JAXBElement<DeletePolitician> createDeletePolitician(DeletePolitician value) {
        return new JAXBElement<DeletePolitician>(_DeletePolitician_QNAME, DeletePolitician.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePoliticianResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePoliticianResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "deletePoliticianResponse")
    public JAXBElement<DeletePoliticianResponse> createDeletePoliticianResponse(DeletePoliticianResponse value) {
        return new JAXBElement<DeletePoliticianResponse>(_DeletePoliticianResponse_QNAME, DeletePoliticianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPoliticians }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllPoliticians }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "getAllPoliticians")
    public JAXBElement<GetAllPoliticians> createGetAllPoliticians(GetAllPoliticians value) {
        return new JAXBElement<GetAllPoliticians>(_GetAllPoliticians_QNAME, GetAllPoliticians.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPoliticiansResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllPoliticiansResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "getAllPoliticiansResponse")
    public JAXBElement<GetAllPoliticiansResponse> createGetAllPoliticiansResponse(GetAllPoliticiansResponse value) {
        return new JAXBElement<GetAllPoliticiansResponse>(_GetAllPoliticiansResponse_QNAME, GetAllPoliticiansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPolitician }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPolitician }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "getPolitician")
    public JAXBElement<GetPolitician> createGetPolitician(GetPolitician value) {
        return new JAXBElement<GetPolitician>(_GetPolitician_QNAME, GetPolitician.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoliticianParti }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPoliticianParti }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "getPoliticianParti")
    public JAXBElement<GetPoliticianParti> createGetPoliticianParti(GetPoliticianParti value) {
        return new JAXBElement<GetPoliticianParti>(_GetPoliticianParti_QNAME, GetPoliticianParti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoliticianPartiResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPoliticianPartiResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "getPoliticianPartiResponse")
    public JAXBElement<GetPoliticianPartiResponse> createGetPoliticianPartiResponse(GetPoliticianPartiResponse value) {
        return new JAXBElement<GetPoliticianPartiResponse>(_GetPoliticianPartiResponse_QNAME, GetPoliticianPartiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoliticianResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPoliticianResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.wsPolitician.com", name = "getPoliticianResponse")
    public JAXBElement<GetPoliticianResponse> createGetPoliticianResponse(GetPoliticianResponse value) {
        return new JAXBElement<GetPoliticianResponse>(_GetPoliticianResponse_QNAME, GetPoliticianResponse.class, null, value);
    }

}
