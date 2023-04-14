package com.wspolitician.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2023-04-14T16:26:10.001+02:00
 * Generated source version: 3.5.5
 *
 */
@WebServiceClient(name = "PoliticianServiceImpService",
                  wsdlLocation = "file:/C:/Users/evafl/Politicians-soap-ws-fonctionnel/Politicians-soap-ws/src/main/webapp/wsdl/politicianserviceimp.wsdl",
                  targetNamespace = "http://www.wsPolitician.com")
public class PoliticianServiceImpService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.wsPolitician.com", "PoliticianServiceImpService");
    public final static QName PoliticianServiceImpPort = new QName("http://www.wsPolitician.com", "PoliticianServiceImpPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/evafl/Politicians-soap-ws-fonctionnel/Politicians-soap-ws/src/main/webapp/wsdl/politicianserviceimp.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PoliticianServiceImpService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/evafl/Politicians-soap-ws-fonctionnel/Politicians-soap-ws/src/main/webapp/wsdl/politicianserviceimp.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PoliticianServiceImpService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PoliticianServiceImpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PoliticianServiceImpService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public PoliticianServiceImpService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PoliticianServiceImpService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PoliticianServiceImpService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns PoliticianServiceImp
     */
    @WebEndpoint(name = "PoliticianServiceImpPort")
    public PoliticianServiceImp getPoliticianServiceImpPort() {
        return super.getPort(PoliticianServiceImpPort, PoliticianServiceImp.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PoliticianServiceImp
     */
    @WebEndpoint(name = "PoliticianServiceImpPort")
    public PoliticianServiceImp getPoliticianServiceImpPort(WebServiceFeature... features) {
        return super.getPort(PoliticianServiceImpPort, PoliticianServiceImp.class, features);
    }

}
