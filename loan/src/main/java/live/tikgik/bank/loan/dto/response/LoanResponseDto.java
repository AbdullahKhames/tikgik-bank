package live.tikgik.bank.loan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoanResponseDto {
    private Long customerId;
    private Double loanAmount;
    private Double interestRate;
    private Double paidAmount;
}
