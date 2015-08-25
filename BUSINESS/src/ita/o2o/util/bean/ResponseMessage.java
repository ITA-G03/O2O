package ita.o2o.util.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public class ResponseMessage {
    private String status;
    private Map<String, String> body;

    public ResponseMessage(String status, Map<String, String> body) {
        this.status = status;
        this.body = body;
    }

    public ResponseMessage() {
        body = new HashMap<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }
}

