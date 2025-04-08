package live.tikgik.bank.bank.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankResponseDto {
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "Bank Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "BankNumber must be 12 digits")
    @Schema(
            description = "Bank Number of the customer", example = "548732457654"
    )
    private String bankNumber;

    @NotEmpty(message = "BankType can not be a null or empty")
    @Schema(
            description = "Type of the bank", example = "Home Bank"
    )
    private String bankType;

    @Positive(message = "Total bank amount should be greater than zero")
    @Schema(
            description = "Total bank amount", example = "100000"
    )
    private int totalAmount;

    @PositiveOrZero(message = "Total bank amount paid should be equal or greater than zero")
    @Schema(
            description = "Total bank amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a bank", example = "99000"
    )
    private int outstandingAmount;
}
