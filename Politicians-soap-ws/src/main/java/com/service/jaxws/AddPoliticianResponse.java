
package com.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.5
 * Fri Apr 14 16:24:22 CEST 2023
 * Generated source version: 3.5.5
 */

@XmlRootElement(name = "addPoliticianResponse", namespace = "http://www.wsPolitician.com")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addPoliticianResponse", namespace = "http://www.wsPolitician.com")

public class AddPoliticianResponse {

    @XmlElement(name = "return")
    private boolean _return;

    public boolean getReturn() {
        return this._return;
    }

    public void setReturn(boolean new_return)  {
        this._return = new_return;
    }

}

