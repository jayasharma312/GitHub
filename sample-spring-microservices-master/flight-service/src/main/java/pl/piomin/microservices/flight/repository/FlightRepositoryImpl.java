package pl.piomin.microservices.flight.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import pl.piomin.microservices.flight.model.Flight;

import java.util.List;

public class FlightRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Flight findFlightById(String id){
        return mongoTemplate.findById(id, Flight.class);
    }

    public List findFlightBySourceAndDestination(String source,String destination){
        Query query = new Query();
        query.addCriteria(Criteria.where("source").is(source).andOperator(Criteria.where("destination").is(destination)));
        return mongoTemplate.find(query, Flight.class);
    }

}
