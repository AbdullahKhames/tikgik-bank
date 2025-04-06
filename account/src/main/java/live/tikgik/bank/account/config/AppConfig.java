package live.tikgik.bank.account.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({AccountsContactInfoDto.class})
public class AppConfig {
    
}
