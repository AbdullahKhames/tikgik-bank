package live.tikgik.bank.bank.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    @Before(value = "@annotation(ToLog)")
    public void logPointcut(JoinPoint joinPoint) throws Throwable {
        log.debug(Thread.currentThread().getName());
        log.debug("executing method: {} with correlation id {}", joinPoint.getSignature().getName(), joinPoint.getArgs()[0]);
    }
}
