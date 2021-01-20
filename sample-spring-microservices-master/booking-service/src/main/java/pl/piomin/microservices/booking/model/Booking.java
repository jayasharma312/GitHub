package pl.piomin.microservices.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Bookings")
public class Booking {


    private String id;
    private String userId;
    private String source;
    private String destination;
    private String flightNo;
    private String paymentId;
    private String status;
    //private List<Account> accounts;

    public Booking(String id, String userId, String name, String type) {
        this.id = id;
        this.userId = userId;
        //this.name = name;
        this.status = type;
    }

}
