package live.tikgik.bank.account.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRequestDto {
    @NotNull
    @Schema(description = "Name of the customer", example = "Abdullah Khames")
    private String name;
    @NotNull
    @Email
    @Schema(description = "Email of the customer", example = "5miiss96@gmail.com")
    private String email;
    @NotNull
    @Schema(description = "Mobile number of the customer", example = "+201126350544")
    private String mobileNumber;
}
