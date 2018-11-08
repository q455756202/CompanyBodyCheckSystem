package team.yingyingmonster.ccbs.service.servicebean;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:12 2018/11/5
 * - 常量表。
 **/
public class Constant {
    /**
     * 角色 - 团检单位
     */
    public static final Integer ROLE_COMPANY            = 1;
    /**
     * 角色 - 医生
     */
    public static final Integer ROLE_DOCTOR             = 2;
    /**
     * 角色 - 总检医生
     */
    public static final Integer ROLE_GENERALDOC         = 3;
    /**
     * 角色 - 前台服务
     */
    public static final Integer ROLE_RECEPTION          = 4;
    /**
     * 角色 - 管理员
     */
    public static final Integer ROLE_ADMIN              = 5;
    /**
     * 角色 - 超级管理员
     */
    public static final Integer ROLE_SUPERADMIN         = 6;

    /**
     * 会话域中储存的登入账号的key值
     */
    public static final String SESSION_LOGIN_ACCOUNT    = "login-account";

    /**
     * 套餐类型 - 持久套餐
     */
    public static final Short COMBO_TYPE_LASTING        = 0;
    /**
     * 套餐类型 - 临时套餐
     */
    public static final Short COMBO_TYPE_TEMP           = 1;

    /**
     * 团检单状态 - 未完成
     */
    public static final Short TEAMFORM_UNDONE           = 0;
    /**
     * 团检单状态 - 已完成
     */
    public static final Short TEAMFORM_DOME             = 1;

    /**
     * 小结状态 - 草稿
     */
    public static final Short REPORT_DRAFT              = 0;
    /**
     * 小结状态 - 提交
     */
    public static final Short REPORT_COMPLETE           = 0;
}
