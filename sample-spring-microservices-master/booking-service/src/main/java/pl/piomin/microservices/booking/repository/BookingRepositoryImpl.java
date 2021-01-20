package pl.piomin.microservices.booking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import pl.piomin.microservices.booking.model.Booking;

import java.util.*;

@Repository
public class BookingRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List findAll() {
        return mongoTemplate.findAll(Booking.class);
    }

    public Booking save(Booking booking) {
        mongoTemplate.save(booking);
        return booking;
    }

    public Booking update(Booking booking){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(booking.getId()));
        Update update = new Update();
        update.set("destination", booking.getDestination());
        update.set("source", booking.getSource());
        return mongoTemplate.findAndModify(query, update, Booking.class);
    }

    public Booking findBookingById(String id){
        return mongoTemplate.findById(id, Booking.class);
    }

    public void deleteById(String deptId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(deptId));
        mongoTemplate.remove(query, Booking.class);
    }
}
