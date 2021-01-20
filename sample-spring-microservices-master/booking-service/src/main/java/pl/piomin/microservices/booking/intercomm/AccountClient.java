package pl.piomin.microservices.booking.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.piomin.microservices.booking.model.Account;

@FeignClient("flight-service")
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/booking/{bookingId}")
    List<Account> getAccounts(@PathVariable("bookingId") Integer bookingId);
    
}
