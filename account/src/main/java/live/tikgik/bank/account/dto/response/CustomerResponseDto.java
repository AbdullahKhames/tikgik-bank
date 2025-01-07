package live.tikgik.bank.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponseDto {
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
}
