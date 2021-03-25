package ua.axiom.aggregator.aspects.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogRequestsAspect {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(
            "within(ua.axiom.diploma.controller..*) &&" +
                    "@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
                    "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
                    "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    protected void callOnControllerRequestMappingMethods() {}

    @Before("callOnControllerRequestMappingMethods()")
    protected void beforeController(JoinPoint jp) {

        logger.debug("AOP: beforeController with args: {}", jp.getArgs());
    }


}
