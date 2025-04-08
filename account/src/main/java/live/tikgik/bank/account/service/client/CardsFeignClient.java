package live.tikgik.bank.account.service.client;

import live.tikgik.bank.account.dto.response.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("card")
public interface CardsFeignClient {
    @GetMapping("/api/v1/cards/{mobileNumber}")
    ResponseEntity<CardsDto> fetchCardDetails(@PathVariable("mobileNumber") String mobileNumber);

}
