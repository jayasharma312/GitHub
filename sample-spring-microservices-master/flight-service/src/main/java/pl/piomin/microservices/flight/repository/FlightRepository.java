package pl.piomin.microservices.flight.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pl.piomin.microservices.flight.model.Flight;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {

    //@Query(value = "{'user.name': ?0}", fields = "{'user' : 0}")
    public Flight findFlightById(String id);

    public List<Flight> findFlightBySourceAndDestination(String source, String destination);
}
