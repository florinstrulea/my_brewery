package florin.my_brewery.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException ex) {
    List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());
    ex.getConstraintViolations().forEach(constraintViolation -> {
      errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
    });
    return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<List<ObjectError>> handleBindException(BindException ex) {
    return new ResponseEntity<List<ObjectError>>(ex.getAllErrors(), HttpStatus.BAD_REQUEST);

  }
}
