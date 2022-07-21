package com.interview.accountvalidations.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentAndParameterExceptions(InvalidInputException e) {
        String errorMessage = e.getMessage();
        return new ResponseEntity<>(new ErrorResponse(errorMessage), HttpStatus.BAD_REQUEST);
    }

    static class ErrorResponse{
        private String errorMessage;

        public ErrorResponse(String message){
            this.errorMessage = message;
        }
        public String getErrorMessage(){
            return errorMessage;
        }
        public void setErrorMessage(String errorMessage){
            this.errorMessage = errorMessage;
        }
    }
}
