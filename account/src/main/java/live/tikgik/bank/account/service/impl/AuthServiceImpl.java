package live.tikgik.bank.account.service.impl;

import live.tikgik.bank.account.dto.request.CustomerRequestDto;
import live.tikgik.bank.account.dto.request.LoginRequest;
import live.tikgik.bank.account.entity.Customer;
import live.tikgik.bank.account.exception.ResourceNotFoundException;
import live.tikgik.bank.account.mapper.CustomerMapper;
import live.tikgik.bank.account.service.AuthService;
import live.tikgik.bank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final CustomerMapper customerMapper;
    private final CustomerService customerService;


    @Override
    public String signup(CustomerRequestDto customerRequestDto) {
        Customer savedCustomer = customerService.save(customerMapper.toEntity(customerRequestDto));
        return "savedCustomer successfully";
    }

    @Override
    public String login(LoginRequest customerRequestDto) {
        Customer savedCustomer = customerService.findByNumberAndPassword(customerRequestDto);
        return "logged in successfully";
    }
}
