package live.tikgik.bank.account.service;

import live.tikgik.bank.account.dto.request.CustomerRequestDto;
import live.tikgik.bank.account.dto.request.LoginRequest;

public interface AuthService {
    String signup(CustomerRequestDto customerRequestDto);
    String login(LoginRequest customerRequestDto);
}
