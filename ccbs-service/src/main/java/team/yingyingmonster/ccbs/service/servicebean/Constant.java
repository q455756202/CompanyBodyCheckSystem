package team.yingyingmonster.ccbs.service.servicebean;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:12 2018/11/5
 * -
 **/
public class Constant {
    public static final Integer
            /**
             * 角色 - 团检单位
             */
            ROLE_COMPANY    = 1,
            /**
             * 角色 - 医生
             */
            ROLE_DOCTOR     = 2,
            /**
             * 角色 - 总检医生
             */
            ROLE_GENERALDOC = 3,
            /**
             * 角色 - 前台服务
             */
            ROLE_RECEPTION  = 4,
            /**
             * 角色 - 管理员
             */
            ROLE_ADMIN      = 5,
            /**
             * 角色 - 超级管理员
             */
            ROLE_SUPERADMIN = 6;

    public static final String
            /**
             * 会话域中储存的登入账号的key值
             */
            SESSION_LOGIN_ACCOUNT       = "login-account";
}
