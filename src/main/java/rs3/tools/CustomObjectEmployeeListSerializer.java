package rs3.tools;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import rs3.persistence.entity.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CustomObjectEmployeeListSerializer extends JsonSerializer {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        List<Employee> tempEmpList;
        List<String> tempEmpNameList = new ArrayList<>();
        try{
            tempEmpList = (List<Employee>) value;
        }catch (ClassCastException castexc){
            castexc.printStackTrace();
            tempEmpList = new ArrayList<>();
        }
        for (Employee emp:tempEmpList) {
            tempEmpNameList.add(emp.getEmployeeName());
        }
        gen.writeString(tempEmpNameList.toString());


    }
}
