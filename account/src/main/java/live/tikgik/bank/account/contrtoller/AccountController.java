package live.tikgik.bank.account.contrtoller;

import live.tikgik.bank.account.aop.ToLog;
import live.tikgik.bank.account.config.AccountsContactInfoDto;
import live.tikgik.bank.account.dto.request.AccountRequestDto;
import live.tikgik.bank.account.dto.response.AccountResponseDto;
import live.tikgik.bank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;
    private final AccountsContactInfoDto accountsContactInfoDto;
    @Value("${build.version}")
    private String buildVersion;
    @PostMapping
    @ToLog
    public ResponseEntity<AccountResponseDto> createAccount(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @RequestBody AccountRequestDto accountRequestDto) {
        log.debug("creating account: {}", accountRequestDto);
        return ResponseEntity.ok(accountService.createAccount(accountRequestDto));
    }
    @DeleteMapping("/{accountId}")
    @ToLog
    public ResponseEntity<String> deleteAccount(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.deleteAccount(accountId));
    }
    @GetMapping("/{accountId}")
    @ToLog
    public ResponseEntity<AccountResponseDto> getAccount(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }
    @ToLog
    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts(
            @RequestHeader("tikGik-correlation-id") String correlationId) {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @PutMapping("/{accountId}")
    @ToLog
    public ResponseEntity<AccountResponseDto> updateAccount(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable Long accountId, @RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, accountRequestDto));
    }

    @GetMapping("/build-version")
    @ToLog
    public String test(
            @RequestHeader("tikGik-correlation-id") String correlationId
            ) {
        return buildVersion;
    }

    @GetMapping("/contact")
    @ToLog
    public AccountsContactInfoDto contact(
            @RequestHeader("tikGik-correlation-id") String correlationId
            ) {
        return accountsContactInfoDto;
    }
}
