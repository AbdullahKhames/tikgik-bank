package live.tikgik.bank.account.service.client;

import live.tikgik.bank.account.dto.response.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{


    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        // u can read from cache or another database or another api!
        return null;
    }
}
