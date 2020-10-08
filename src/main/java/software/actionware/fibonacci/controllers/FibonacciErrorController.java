package software.actionware.fibonacci.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import software.actionware.fibonacci.model.FibonacciResult;

import java.math.BigInteger;

/**
 *
 * Fecha: 07/10/2020.
 * Autores: Carlos Cuesta
 */
@RestControllerAdvice
public class FibonacciErrorController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FibonacciResult result = new FibonacciResult("/errors/request-not-found", ex.getClass().getSimpleName(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), getURIDescription(request), BigInteger.ZERO);
        return handleExceptionInternal(ex, result, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class, IllegalArgumentException.class})
    protected ResponseEntity<Object> handleArgumentTypeMismatch(RuntimeException ex, WebRequest request) {
        FibonacciResult result = new FibonacciResult("/errors/request-error", ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), getURIDescription(request), BigInteger.ZERO);
        return handleExceptionInternal(ex, result, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private static String getURIDescription(WebRequest request){
        if (request instanceof ServletWebRequest) {
            return ((ServletWebRequest) request).getRequest().getRequestURI();
        } else {
            return request.getDescription(false);
        }
    }

}
