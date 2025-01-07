package live.tikgik.bank.account.contrtoller;

import jakarta.validation.Valid;
import live.tikgik.bank.account.dto.request.CustomerRequestDto;
import live.tikgik.bank.account.dto.response.ResponseDto;
import live.tikgik.bank.account.service.AuthService;
import live.tikgik.bank.account.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<ResponseDto<String>> signup(@Valid CustomerRequestDto customerRequestDto) {
        String response = authService.signup(customerRequestDto);
        return ResponseEntity
                .ok(ResponseBuilder.buildSuccessResponse(response, "Signup successful"));
    }

}
