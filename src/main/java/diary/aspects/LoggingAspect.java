package diary.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // what is a point cut? what is a joinpoint?
    // how to do logging of certain sets of methods

    private void log(String message) {
        System.out.println(message);
    }
}
