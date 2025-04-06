package live.tikgik.bank.loan.controller;

import live.tikgik.bank.loan.config.LoansContactInfoDto;
import live.tikgik.bank.loan.dto.request.LoanRequestDto;
import live.tikgik.bank.loan.dto.response.LoanResponseDto;
import live.tikgik.bank.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;
    private final LoansContactInfoDto accountsContactInfoDto;
    @Value("${build.version}")
    private String buildVersion;
    @PostMapping
    public ResponseEntity<LoanResponseDto> create(@RequestBody LoanRequestDto loanRequestDto) {
        return ResponseEntity.ok(loanService.createLoan(loanRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.deleteLoan(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoan(id));
    }
    @GetMapping
    public ResponseEntity<List<LoanResponseDto>> getAll() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDto> update(@PathVariable Long id, @RequestBody LoanRequestDto loanRequestDto) {
        return ResponseEntity.ok(loanService.updateLoan(id, loanRequestDto));
    }

    @GetMapping("/build-version")
    public String test() {
        return buildVersion;
    }

    @GetMapping("/contact")
    public LoansContactInfoDto contact() {
        return accountsContactInfoDto;
    }
}
