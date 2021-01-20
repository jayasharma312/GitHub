package pl.piomin.microservices.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.piomin.microservices.booking.model.Booking;

import java.math.BigInteger;
import java.util.*;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

//    @Query(value = "{'user.name': ?0}", fields = "{'user' : 0}")
//    Booking findBookingByUserId(String userId);

    public List findAll();

    public Booking save(Booking booking);

    public Booking update(Booking booking);

    public Booking findBookingById(String id);

    public void deleteById(String deptId);

}
