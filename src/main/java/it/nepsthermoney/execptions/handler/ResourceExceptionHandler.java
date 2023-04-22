package it.nepsthermoney.execptions.handler;


import it.nepsthermoney.execptions.ConflictsException;
import it.nepsthermoney.execptions.ObjectNotFoundException;
import it.nepsthermoney.execptions.error.StandardError;
import it.nepsthermoney.execptions.error.ValidationError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException notFoundException) {
        StandardError errorMessage = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException notFoundException) {
        StandardError errorMessage = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException notFoundException) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),"Field validation error");
        for (FieldError x : notFoundException.getBindingResult().getFieldErrors()) {
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConflictsException.class)
    public ResponseEntity<StandardError> objectFoundException(ConflictsException foundException) {
        StandardError errorMessage = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), foundException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

  /*  @ExceptionHandler(UserDisabledException.class)
    public ResponseEntity<StandardError> userDisabledException(UserDisabledException userDisabled) {
        StandardError errorMessage = new StandardError(System.currentTimeMillis(), HttpStatus.UNAUTHORIZED.value(), userDisabled.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }

    @ExceptionHandler(CredentialInvalidException.class)
    public ResponseEntity<StandardError> credentialInvalidException(CredentialInvalidException credentialInvalid) {
        StandardError errorMessage = new StandardError(System.currentTimeMillis(), HttpStatus.UNAUTHORIZED.value(), credentialInvalid.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }*/
}
