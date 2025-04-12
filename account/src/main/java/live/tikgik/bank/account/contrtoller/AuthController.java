package live.tikgik.bank.account.contrtoller;

import jakarta.validation.Valid;
import live.tikgik.bank.account.aop.ToLog;
import live.tikgik.bank.account.dto.request.CustomerRequestDto;
import live.tikgik.bank.account.dto.request.LoginRequest;
import live.tikgik.bank.account.dto.response.ResponseDto;
import live.tikgik.bank.account.service.AuthService;
import live.tikgik.bank.account.uils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    @ToLog
    public ResponseEntity<ResponseDto<String>> signup(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        String response = authService.signup(customerRequestDto);
        return ResponseEntity
                .ok(ResponseBuilder.buildSuccessResponse(response, "Signup successful"));
    }

    @PostMapping("/login")
    @ToLog
    public ResponseEntity<ResponseDto<String>> login(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @Valid  @RequestBody LoginRequest customerRequestDto) {
        String response = authService.login(customerRequestDto);
        return ResponseEntity
                .ok(ResponseBuilder.buildSuccessResponse(response, "login successful"));
    }

}
