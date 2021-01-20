package pl.piomin.microservices.booking.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public BookingNotFoundException(String cause) {
        super("No such booking with " + cause);
    }

}
