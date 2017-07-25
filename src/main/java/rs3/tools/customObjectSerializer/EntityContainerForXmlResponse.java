package rs3.tools.customObjectSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

// Created and used because Xml response body needs a single root element

@XmlRootElement(name = "containers")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntityContainerForXmlResponse {

    @XmlElement(name = "container")
    public List<String> container;

    public EntityContainerForXmlResponse() {
    }

    public EntityContainerForXmlResponse(List<String> container) {

        this.container = container;
    }

    public List<String> getContainer() {
        return container;
    }

    public void setContainer(List<String> container) {
        this.container = container;
    }

}
