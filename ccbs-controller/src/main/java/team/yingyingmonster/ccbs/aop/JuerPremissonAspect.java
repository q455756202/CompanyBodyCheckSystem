package team.yingyingmonster.ccbs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import team.yingyingmonster.ccbs.aop.annotation.Namespace;
import team.yingyingmonster.ccbs.common.AnnotationUtil;
import team.yingyingmonster.ccbs.controller.GatewayAction;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Log;
import team.yingyingmonster.ccbs.database.bean.Role;
import team.yingyingmonster.ccbs.database.mapper.LogMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerLogMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerPremissionMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.service.servicebean.Constant;

import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:42 2018/11/14
 * -
 **/
@Aspect
@Component
public class JuerPremissonAspect {
    @Autowired
    private JuerLogMapper juerLogMapper;
    @Autowired
    private JuerPremissionMapper juerPremissionMapper;

    @Pointcut("execution (team.yingyingmonster.ccbs.bean.ResultMessage team.yingyingmonster.ccbs.controller.*Action.*(..))")
    private void pointcut() {};

    @Before("pointcut()")
    public void before(JoinPoint point) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpSession session = (HttpSession) attributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Account account = (Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT);
        if (account == null) {
            account = new Account();
            account.setAccountname("未登入");
            account.setAccountid(-1l);
            account.setAccountstate(Constant.ACCOUNT_STATE_DEFAULT);
            account.setRoleid(0l);
        }

        String methodName = point.getSignature().getName();
//        String namespace;
//        Long premissionLevel;
//        Namespace anno = AnnotationUtil.getMethodAnnotation(point, Namespace.class);
//        if (anno == null) {
//            RequestMapping mapping = AnnotationUtil.getMethodAnnotation(point, RequestMapping.class);
//            namespace = mapping.name();
//            Role role = juerPremissionMapper.selectRoleByMenuname(namespace);
//            premissionLevel = role==null?Constant.ROLE_SUPERADMIN:role.getRoleid();
//        } else {
//            namespace = anno==null?"null":anno.name();
//            premissionLevel = anno==null?Constant.ROLE_SUPERADMIN:anno.premissionLevel();
//        }

//        if (premissionLevel != account.getRoleid() && !(point.getTarget() instanceof GatewayAction))
//            throw new RuntimeException("not allow to call this method!");

        Log log = new Log();
        log.setLogid(juerLogMapper.getNewId());
        log.setLogclass(point.getTarget().getClass().getName());
        log.setLoglevel("INFO");
        log.setLoglocate(point.getKind());
        log.setLogmessage("用户 " + account.getAccountname() + " 访问了 " + ((MethodSignature)point.getSignature()).getMethod().getName());
        log.setLogthread(Thread.currentThread().getName());
        log.setLogtime(new Date(System.currentTimeMillis()));

        juerLogMapper.insert(log);
        System.out.println(JsonUtil.beanToJson(log, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
    }
}

