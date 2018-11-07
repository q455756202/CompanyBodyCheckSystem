package team.yingyingmonster.ccbs.service.servicebean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:02 2018/11/5
 * -
 **/
public class AdviceBeforeHandler implements MethodBeforeAdvice {
    private Logger logger = LogManager.getLogger("OracleLogger");

    @Override
    public void before(Method method, Object[] params, Object result) throws Throwable {
        logger.debug(MarkerManager.getMarker("db"), "");
    }
}
