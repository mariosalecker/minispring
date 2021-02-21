package diary.apects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // what is a point cut? what is a joinpoint?

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log("Starting " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        log("Finished " + joinPoint.getSignature());
        return result;
    }

    private void log(String message) {
        System.out.println(message);
    }
}
