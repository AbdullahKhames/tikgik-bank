package live.tikgik.bank.bank.service.impl;

import live.tikgik.bank.bank.dto.request.BankRequestDto;
import live.tikgik.bank.bank.dto.response.BankResponseDto;
import live.tikgik.bank.bank.entityy.Bank;
import live.tikgik.bank.bank.exception.ResourceNotFoundException;
import live.tikgik.bank.bank.mapper.BankMapper;
import live.tikgik.bank.bank.repository.BankRepository;
import live.tikgik.bank.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BankServiceImpl implements BankService {
    private final BankMapper bankMapper;
    private final BankRepository bankRepository;
    @Override
    @Transactional

    public BankResponseDto createBank(BankRequestDto accountRequestDto) {
        Bank bank = bankMapper.fromDto(accountRequestDto);
        return bankMapper.toDto(bankRepository.save(bank));
    }

    @Override
    @Transactional

    public String deleteBank(Long accountId) {
        Bank bank = bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "accountId", accountId));
        bankRepository.delete(bank);
        return "deleted successfully";
    }

    @Override
    public BankResponseDto getBank(Long accountId) {
        Bank bank = bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "accountId", accountId));
        return bankMapper.toDto(bank);
    }

    @Override
    public List<BankResponseDto> getAllBanks() {
        return bankRepository.findAll()
                .stream()
                .map(bankMapper::toDto)
                .toList();
    }

    @Override
    @Transactional

    public BankResponseDto updateBank(Long accountId, BankRequestDto accountRequestDto) {
        Bank bank = bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "accountId", accountId));
        bankMapper.updateBank(bank, accountRequestDto);
        return bankMapper.toDto(bankRepository.save(bank));
    }
}
