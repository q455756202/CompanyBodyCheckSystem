package team.yingyingmonster.ccbs.web;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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

    public static HtmlPage getAjaxHtml(String url, int timeout, JavaScriptErrorListener listener) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(timeout);

        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        if (listener != null)
            webClient.setJavaScriptErrorListener(listener);

        return webClient.getPage(url);
    }
}
