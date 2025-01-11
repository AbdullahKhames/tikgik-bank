package live.tikgik.bank.account.contrtoller;

import live.tikgik.bank.account.dto.request.AccountRequestDto;
import live.tikgik.bank.account.dto.response.AccountResponseDto;
import live.tikgik.bank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.ok(accountService.createAccount(accountRequestDto));
    }
    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.deleteAccount(accountId));
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }
    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> updateAccount(@PathVariable Long accountId, @RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, accountRequestDto));
    }
}
