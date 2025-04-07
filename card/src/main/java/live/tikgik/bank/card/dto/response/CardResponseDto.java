package live.tikgik.bank.card.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardResponseDto {
    private Long customerId;
    private Double cardAmount;
    private Double interestRate;
    private Double paidAmount;
}
