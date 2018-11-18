package team.yingyingmonster.ccbs.service.servicebean;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:12 2018/11/5
 * - 常量表。
 **/
public class Constant {
    /**
     * 角色 - 未登入（游客）
     */
    public static final Long ROLE_UNLOGIN               = 0L;
    /**
     * 角色 - 团检单位
     */
    public static final Long ROLE_COMPANY               = 1L;
    /**
     * 角色 - 医生
     */
    public static final Long ROLE_DOCTOR                = 2L;
    /**
     * 角色 - 总检医生
     */
    public static final Long ROLE_GENERALDOC            = 3L;
    /**
     * 角色 - 前台服务
     */
    public static final Long ROLE_RECEPTION             = 4L;
    /**
     * 角色 - 管理员
     */
    public static final Long ROLE_ADMIN                 = 5L;
    /**
     * 角色 - 超级管理员
     */
    public static final Long ROLE_SUPERADMIN            = 6L;

    /**
     * 账号状态 - 默认
     */
    public static final Short ACCOUNT_STATE_DEFAULT   = 0;
    /**
     * 账号状态 - 关闭
     */
    public static final Short ACCOUNT_STATE_CLOSE     = 1;
    /**
     * 账号状态 - 删除
     */
    public static final Short ACCOUNT_STATE_DELETE    = 2;

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

    /**
     * 菜单状态 - 启用
     */
    public static final Short MENU_STATE_ENABLE         = 0;
    /**
     * 菜单状态 - 禁用
     */
    public static final Short MENU_STATE_DISABLE        = 1;
}
