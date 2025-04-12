package live.tikgik.bank.account.service.client;

import live.tikgik.bank.account.dto.response.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("card")
public interface CardsFeignClient {
    @GetMapping("/api/v1/cards/{mobileNumber}")
    ResponseEntity<CardsDto> fetchCardDetails(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable("mobileNumber") String mobileNumber);

}
