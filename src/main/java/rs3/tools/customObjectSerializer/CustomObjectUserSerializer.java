package rs3.tools.customObjectSerializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import rs3.persistence.entity.User;

import java.io.IOException;

public class CustomObjectUserSerializer extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        User tempUser;
        try{
            tempUser = (User) value;

        } catch (ClassCastException castexc){
            castexc.printStackTrace();
            gen.writeString("null");
            tempUser = null;
        }
        gen.writeString(tempUser.getName());
    }
}
