package live.tikgik.bank.account.service;

import live.tikgik.bank.account.dto.request.CustomerRequestDto;

public interface AuthService {
    String signup(CustomerRequestDto customerRequestDto);
}
