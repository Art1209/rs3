package rs3.tools;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import rs3.persistence.entity.Department;

import java.io.IOException;

public class CustomObjectDepartmentSerializer extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        Department tempDep;
        try{
            tempDep = (Department) value;

        } catch (ClassCastException castexc){
            castexc.printStackTrace();
            gen.writeString("null");
            tempDep = null;
        }
        gen.writeString(tempDep.getDepartmentName());
    }
}
