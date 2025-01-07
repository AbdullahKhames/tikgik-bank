package live.tikgik.bank.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountResponseDto {
    private Long customerId;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    private CustomerResponseDto customer;
}
