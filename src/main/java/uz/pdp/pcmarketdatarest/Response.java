package uz.pdp.pcmarketdatarest;

import java.util.Map;

import lombok.Data;

@Data
public class Response {
    private String message;
    private Object data;
    private Map<String, String> errors;

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Response(String message) {
        this.message = message;
    }
}
