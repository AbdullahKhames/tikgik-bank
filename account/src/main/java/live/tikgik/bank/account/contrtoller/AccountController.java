package live.tikgik.bank.account.contrtoller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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
import java.util.Map;

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
            
            @RequestBody AccountRequestDto accountRequestDto) {
        log.debug("creating account: {}", accountRequestDto);
        return ResponseEntity.ok(accountService.createAccount(accountRequestDto));
    }
    @DeleteMapping("/{accountId}")
    @ToLog
    public ResponseEntity<String> deleteAccount(
            
            @PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.deleteAccount(accountId));
    }
    @GetMapping("/{accountId}")
    @ToLog
    public ResponseEntity<AccountResponseDto> getAccount(
            
            @PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }
    @ToLog
    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts(
            ) {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @PutMapping("/{accountId}")
    @ToLog
    public ResponseEntity<AccountResponseDto> updateAccount(
            
            @PathVariable Long accountId, @RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, accountRequestDto));
    }

    @Retry(name = "getBuildVersion",
            fallbackMethod = "getBuildVersionFallback")
    @GetMapping("/build-version")
    @ToLog
    public String test(
            
            ) {
        return buildVersion;
    }

    // must be of same signature except of name and add throwable parameter
    public String getBuildVersionFallback(
            Throwable throwable
    ) {
        log.error("getBuildVersionFallback", throwable);
        return "0.9";
    }
    @RateLimiter(name = "getContactInfo", fallbackMethod = "getContactInfoFallBack")
    @GetMapping("/contact")
    @ToLog
    public AccountsContactInfoDto contact(
            
            ) {
        return accountsContactInfoDto;
    }
    public AccountsContactInfoDto getContactInfoFallBack(
                Throwable throwable
            ) {
        log.error("getContactInfoFallBack", throwable);
        return new AccountsContactInfoDto(
                "default Contacts",
                Map.of("name", "hamada"),
                List.of("123")
        );
    }

}
