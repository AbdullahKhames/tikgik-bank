package live.tikgik.bank.bank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankRequestDto {
    private Long customerId;
    private Double bankAmount;
}
