package live.tikgik.bank.bank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankResponseDto {
    private Long customerId;
    private Double bankAmount;
    private Double interestRate;
    private Double paidAmount;
}
