package pl.piomin.microservices.flight.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piomin.microservices.flight.exceptions.FlightNotFoundException;
import pl.piomin.microservices.flight.model.Flight;
import pl.piomin.microservices.flight.repository.FlightRepository;
import pl.piomin.microservices.flight.repository.FlightRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class Api {

    @Autowired
    FlightRepository flightRepositoryImpl;

    public Api() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Flight findFlightById(@PathVariable("id") String id) throws FlightNotFoundException {
        log.info("Flight.findById(%s)", id);
        Flight flight = flightRepositoryImpl.findFlightById(id);
        return flight;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{source}/{dest}")
    public List<Flight> findBySourceAndDestination(@PathVariable("source") String source,@PathVariable("dest") String destination) throws FlightNotFoundException {
        log.info(String.format("Flight.findBy source and destination", source+destination));
        return flightRepositoryImpl.findFlightBySourceAndDestination(source,destination);
    }


}
