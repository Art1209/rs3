//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.16 at 10:04:21 AM MSK 
//


package rs3.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs3.soap package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs3.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployeeRequest }
     * 
     */
    public GetEmployeeRequest createGetEmployeeRequest() {
        return new GetEmployeeRequest();
    }

    /**
     * Create an instance of {@link GetEmployeeResponse }
     * 
     */
    public GetEmployeeResponse createGetEmployeeResponse() {
        return new GetEmployeeResponse();
    }

    /**
     * Create an instance of {@link EmployeeFromXsd }
     * 
     */
    public EmployeeFromXsd createEmployeeFromXsd() {
        return new EmployeeFromXsd();
    }

    /**
     * Create an instance of {@link GetDepartmentResponse }
     * 
     */
    public GetDepartmentResponse createGetDepartmentResponse() {
        return new GetDepartmentResponse();
    }

    /**
     * Create an instance of {@link DepartmentFromXsd }
     * 
     */
    public DepartmentFromXsd createDepartmentFromXsd() {
        return new DepartmentFromXsd();
    }

    /**
     * Create an instance of {@link GetDepartmentRequest }
     * 
     */
    public GetDepartmentRequest createGetDepartmentRequest() {
        return new GetDepartmentRequest();
    }

}
