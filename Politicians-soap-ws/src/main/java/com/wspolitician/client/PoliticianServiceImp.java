package com.wspolitician.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2023-04-14T16:26:09.997+02:00
 * Generated source version: 3.5.5
 *
 */
@WebService(targetNamespace = "http://www.wsPolitician.com", name = "PoliticianServiceImp")
@XmlSeeAlso({ObjectFactory.class})
public interface PoliticianServiceImp {

    @WebMethod
    @RequestWrapper(localName = "deletePolitician", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.DeletePolitician")
    @ResponseWrapper(localName = "deletePoliticianResponse", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.DeletePoliticianResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deletePolitician(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getAllPoliticians", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.GetAllPoliticians")
    @ResponseWrapper(localName = "getAllPoliticiansResponse", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.GetAllPoliticiansResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.wspolitician.client.Politician> getAllPoliticians()
;

    @WebMethod
    @RequestWrapper(localName = "getPoliticianParti", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.GetPoliticianParti")
    @ResponseWrapper(localName = "getPoliticianPartiResponse", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.GetPoliticianPartiResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getPoliticianParti(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );

    @WebMethod
    @RequestWrapper(localName = "addPolitician", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.AddPolitician")
    @ResponseWrapper(localName = "addPoliticianResponse", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.AddPoliticianResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean addPolitician(

        @WebParam(name = "arg0", targetNamespace = "")
        com.wspolitician.client.Politician arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getPolitician", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.GetPolitician")
    @ResponseWrapper(localName = "getPoliticianResponse", targetNamespace = "http://www.wsPolitician.com", className = "com.wspolitician.client.GetPoliticianResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.wspolitician.client.Politician getPolitician(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );
}
