package live.tikgik.bank.loan.service.impl;

import live.tikgik.bank.loan.dto.request.LoanRequestDto;
import live.tikgik.bank.loan.dto.response.LoanResponseDto;
import live.tikgik.bank.loan.entityy.Loan;
import live.tikgik.bank.loan.exception.ResourceNotFoundException;
import live.tikgik.bank.loan.mapper.LoanMapper;
import live.tikgik.bank.loan.repository.LoanRepository;
import live.tikgik.bank.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class LoanServiceImpl implements LoanService {
    private final LoanMapper loanMapper;
    private final LoanRepository loanRepository;
    @Override
    @Transactional
    public LoanResponseDto createLoan(LoanRequestDto accountRequestDto) {
        Loan loan = loanMapper.fromDto(accountRequestDto);
        loan.setInterestRate(0.1);
        loan.setPaidAmount(0.0);
        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    @Transactional

    public String deleteLoan(Long accountId) {
        Loan loan = loanRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "accountId", accountId));
        loanRepository.delete(loan);
        return "deleted successfully";
    }

    @Override
    public LoanResponseDto getLoan(Long accountId) {
        Loan loan = loanRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "accountId", accountId));
        return loanMapper.toDto(loan);
    }

    @Override
    public List<LoanResponseDto> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toDto)
                .toList();
    }

    @Override
    @Transactional

    public LoanResponseDto updateLoan(Long accountId, LoanRequestDto accountRequestDto) {
        Loan loan = loanRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "accountId", accountId));
        loanMapper.updateLoan(loan, accountRequestDto);
        return loanMapper.toDto(loanRepository.save(loan));
    }
}
