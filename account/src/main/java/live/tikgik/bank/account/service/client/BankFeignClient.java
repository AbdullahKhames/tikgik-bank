package live.tikgik.bank.account.service.client;

import live.tikgik.bank.account.dto.response.BankDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bank")
public interface BankFeignClient {

    @GetMapping("/api/v1/banks/{mobileNumber}")
    ResponseEntity<BankDto> fetchLoanDetails(@PathVariable("mobileNumber") String mobileNumber);

}
