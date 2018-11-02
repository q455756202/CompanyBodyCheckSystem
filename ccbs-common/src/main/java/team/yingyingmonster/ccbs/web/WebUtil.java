package team.yingyingmonster.ccbs.web;

import javax.servlet.http.HttpSession;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 9:40 2018/11/1
 * - 用于提供web中所需的通用方法
 **/
public class WebUtil {
    /**
     * 获取到指向目标地址的真实路径。
     * @param session HttpSession，使用SpringMVC时，可通过在参数列表中添加该参数来使SpringMVC自动注入。
     * @param path 目标地址。
     * @return 真实路径。
     */
    public static String getRealPath(HttpSession session, String path) {
        return session.getServletContext().getRealPath(path);
    }
}
