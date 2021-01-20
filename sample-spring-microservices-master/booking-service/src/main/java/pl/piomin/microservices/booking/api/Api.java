package pl.piomin.microservices.booking.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piomin.microservices.booking.exceptions.BookingNotFoundException;
import pl.piomin.microservices.booking.intercomm.AccountClient;
import pl.piomin.microservices.booking.model.Account;
import pl.piomin.microservices.booking.model.Booking;
import pl.piomin.microservices.booking.model.BookingType;
import pl.piomin.microservices.booking.repository.BookingRepository;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class Api {

//    @Autowired
//    private AccountClient accountClient;

    @Autowired
    BookingRepository bookingRepositoryImpl;

    private List<Booking> bookings;

    public Api() {

    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Booking> findAll() {
        log.info("Booking.findAll()");
        return bookingRepositoryImpl.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Booking findById(@PathVariable("id") String id) throws BookingNotFoundException {
        log.info(String.format("Booking.findById(%s)", id));
        Booking booking = bookingRepositoryImpl.findBookingById(id);
        return booking;
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Booking createNewBooking(@RequestBody Booking booking) {
        log.info("Booking.createNewBooking()");
        if (booking.getId() != null) {
            return null;
        }
        bookingRepositoryImpl.save(booking);
        return booking;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{bookingId}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable String bookingId) {
        booking.setId(bookingId);
        bookingRepositoryImpl.update(booking);
        return booking;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteBooking(@PathVariable String id) {
        log.info("Booking.deleteBooking()");
        bookingRepositoryImpl.deleteById(id);
//        try {
//            Booking byId = findById(id);
//            bookings.remove(byId);
//        } catch (BookingNotFoundException e) {
//            return false;
//        }
        return true;
    }

}
