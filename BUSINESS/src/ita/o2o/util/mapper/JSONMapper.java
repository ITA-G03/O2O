package ita.o2o.util.mapper;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Order;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public class JSONMapper extends ObjectMapper{
    public static final String DATA_STRING_PREFIX="{\"data\":";
    public static final String DATA_STRING_SUFFIX="}";

    ObjectMapper objectMapper;

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JSONMapper(){
        objectMapper=new ObjectMapper();
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }


    public String writeObjectAsString(Object value){
        try {
            return objectMapper.writeValueAsString(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return O2OConstants.EMPTY;
    }



    public String writeObjectAsDataString(Object value){
        try {
            return DATA_STRING_PREFIX+objectMapper.writeValueAsString(value)+DATA_STRING_SUFFIX;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return O2OConstants.EMPTY;
    }
    
    
    public <T> T readStringAsObject(String str,Class<?> c,Class<?>... e) {
    	
    	JavaType javaType = this.getTypeFactory().constructParametricType(c,e);
    	T o = null;
    	try {
    		o= objectMapper.readValue(str,javaType);
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	return o;
    	
    }
    
    
}
