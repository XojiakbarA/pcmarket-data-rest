package uz.pdp.pcmarketdatarest.handler;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.pcmarketdatarest.Response;
import uz.pdp.pcmarketdatarest.exception.ProductNotEnoughException;
import uz.pdp.pcmarketdatarest.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handleResourceNotFound(ResourceNotFoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotEnoughException.class)
    public ResponseEntity<Response> handleAmountExceeds(RuntimeException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<Response> handleConstraintViolation(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        e.getConstraintViolations().forEach(
                c -> {
                    String field = null;
                    for (Path.Node node : c.getPropertyPath()) {
                        field = node.getName();
                    }
                    errors.put(field, c.getMessage());
                }
        );
        Response response = new Response(HttpStatus.BAD_REQUEST.name(), errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for(FieldError error : e.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        Response response = new Response(HttpStatus.BAD_REQUEST.name(), errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public Response handle(RuntimeException e) {
//        Response response = new Response();
//        response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());
//        return response;
//    }
}
