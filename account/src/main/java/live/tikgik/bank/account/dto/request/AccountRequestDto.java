package live.tikgik.bank.account.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountRequestDto {
    private String mobileNumber;
    private String accountType;
    private String branchAddress;
}
