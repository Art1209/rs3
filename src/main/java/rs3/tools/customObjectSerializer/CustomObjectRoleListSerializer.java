package rs3.tools.customObjectSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import rs3.persistence.entity.Role;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CustomObjectRoleListSerializer extends JsonSerializer {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        List<Role> tempRoleList;
        List<String> tempRoleNameList = new ArrayList<>();
        try{
            tempRoleList = (List<Role>) value;
        }catch (ClassCastException castexc){
            castexc.printStackTrace();
            tempRoleList = new ArrayList<>();
        }
        for (Role role:tempRoleList) {
            tempRoleNameList.add(role.getRole());
        }
        gen.writeString(tempRoleNameList.toString());


    }
}
