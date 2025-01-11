package live.tikgik.bank.account.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequest {
    @NotNull
    @Schema(description = "Mobile number of the customer", example = "+201126350544")
    private String mobileNumber;
    @NotNull
    @Schema(description = "password of the customer", example = "123")
    private String password;
}
