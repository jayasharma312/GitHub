package pl.piomin.microservices.flight.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class FlightNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public FlightNotFoundException(String cause) {
        super("No such flight with " + cause);
    }

}
