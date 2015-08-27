package ita.o2o.util.bean;

import java.util.HashMap;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public class ResponseMessage {
    private String status;
    private HashMap<String,String> body;

    public ResponseMessage(String status, HashMap<String, String> body) {
        this.status = status;
        this.body = body;
    }

    public ResponseMessage() {
        body=new HashMap<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, String> getBody() {
        return body;
    }

    public void setBody(HashMap<String, String> body) {
        this.body = body;
    }
}

