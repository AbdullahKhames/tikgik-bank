package live.tikgik.bank.loan.service;

import live.tikgik.bank.loan.dto.request.LoanRequestDto;
import live.tikgik.bank.loan.dto.response.LoanResponseDto;

import java.util.List;

public interface LoanService {
    LoanResponseDto createLoan(LoanRequestDto accountRequestDto);

    String deleteLoan(Long accountId);

    LoanResponseDto getLoan(Long accountId);

    List<LoanResponseDto> getAllLoans();

    LoanResponseDto updateLoan(Long accountId, LoanRequestDto accountRequestDto);
}
