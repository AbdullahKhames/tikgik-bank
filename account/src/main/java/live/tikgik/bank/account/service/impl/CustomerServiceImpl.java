package live.tikgik.bank.account.service.impl;

import live.tikgik.bank.account.dto.request.LoginRequest;
import live.tikgik.bank.account.dto.response.CustomerResponseDto;
import live.tikgik.bank.account.entity.Customer;
import live.tikgik.bank.account.exception.ResourceAlreadyExistException;
import live.tikgik.bank.account.exception.ResourceNotFoundException;
import live.tikgik.bank.account.mapper.CustomerMapper;
import live.tikgik.bank.account.repository.CustomerRepository;
import live.tikgik.bank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Customer save(Customer entity) {
        if (customerRepository.existsByMobileNumber(entity.getMobileNumber())) {
            throw new ResourceAlreadyExistException("Customer", "mobileNumber", entity.getMobileNumber());
        }
        return customerRepository.save(entity);
    }

    @Override
    public Customer findByNumberAndPassword(LoginRequest customerRequestDto) {
        return customerRepository.findByMobileNumberAndPassword(customerRequestDto.getMobileNumber(), customerRequestDto.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "number", customerRequestDto.getMobileNumber()));
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
    }

    @Override
    public CustomerResponseDto toDto(Customer customer) {
        return customerMapper.toDto(customer);
    }
}
