package live.tikgik.bank.loan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoanRequestDto {
    private Long customerId;
    private Double loanAmount;
}
