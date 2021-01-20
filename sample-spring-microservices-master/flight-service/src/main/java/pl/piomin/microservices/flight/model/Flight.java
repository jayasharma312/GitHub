package pl.piomin.microservices.flight.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Flights")
public class Flight {

    private String id;
    private String flightName;
    private String source;
    private String destination;
    private String arrivalDate;
    private String departureDate;
    private String noOfSeats;
    private String status;

}
