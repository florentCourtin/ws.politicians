
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

@XmlRootElement(name = "addPolitician", namespace = "http://www.wsPolitician.com")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addPolitician", namespace = "http://www.wsPolitician.com")

public class AddPolitician {

    @XmlElement(name = "arg0")
    private com.service.Politician arg0;

    public com.service.Politician getArg0() {
        return this.arg0;
    }

    public void setArg0(com.service.Politician newArg0)  {
        this.arg0 = newArg0;
    }

}
