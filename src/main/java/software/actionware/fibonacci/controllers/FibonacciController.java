package software.actionware.fibonacci.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.actionware.fibonacci.domain.FibonacciCalc;
import software.actionware.fibonacci.model.FibonacciResult;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 *
 * Fecha: 06/10/2020.
 * Autores: Carlos Cuesta
 */
@RestController
public class FibonacciController {

    /**
     *
     * @param request (required) the HttpServletRequest
     * @param position (required) the position of the Fibonacci sequence to calculate
     * @return ResponseEntity with FibonacciResult object that implements IETF devised RFC 7807 error-handling schema
     */
    @GetMapping(
            path = {"/fibonacci/{position}"},
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<FibonacciResult> getFibonacciPosition(HttpServletRequest request, @PathVariable Optional<Integer> position) {
        BigInteger result = BigInteger.ZERO;
        try {
            result = FibonacciCalc.getFibonacciNumber(position.get());
        } catch (IllegalArgumentException iae) {
            return ResponseEntity
                    .badRequest()
                    .body(new FibonacciResult("/errors/bad-parameters", HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), iae.getMessage(), request.getRequestURI(),  result));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new FibonacciResult("/errors/server-error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), request.getRequestURI(),  result));
        }
        return ResponseEntity
                .ok(new FibonacciResult("", HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), "", request.getRequestURI(),  result));
    }

}
