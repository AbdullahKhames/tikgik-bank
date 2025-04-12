package live.tikgik.bank.account.contrtoller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import live.tikgik.bank.account.aop.ToLog;
import live.tikgik.bank.account.dto.response.CustomerDetailsDto;
import live.tikgik.bank.account.dto.response.ErrorDto;
import live.tikgik.bank.account.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "REST API for Customers in EazyBank",
        description = "REST APIs in EazyBank to FETCH customer details"
)
@RestController
@RequestMapping(path="/v1/customers", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Slf4j
public class CustomerController {

    private final CustomerService iCustomerService;

    public CustomerController(CustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }

    @Operation(
            summary = "Fetch Customer Details REST API",
            description = "REST API to fetch Customer details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetchCustomerDetails")
    @ToLog
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @RequestParam @Pattern(regexp="^\\+\\d{12}$", message = "Mobile number must start with '+' and be exactly 13 digits")
                                                                   String mobileNumber){
        CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(mobileNumber, correlationId);
        return ResponseEntity.status(HttpStatus.SC_OK).body(customerDetailsDto);

    }


}
