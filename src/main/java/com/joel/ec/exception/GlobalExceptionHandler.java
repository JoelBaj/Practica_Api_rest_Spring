package com.joel.ec.exception;


import com.joel.ec.model.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                  WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);

    }

}
