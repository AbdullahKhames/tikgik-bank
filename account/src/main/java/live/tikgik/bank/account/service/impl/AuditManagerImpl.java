package live.tikgik.bank.account.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class AuditManagerImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("5miiiss");
    }
}
