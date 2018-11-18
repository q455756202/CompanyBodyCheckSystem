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

    public static HtmlPage getAjaxHtml(String url, int timeout, JavaScriptErrorListener listener) throws IOException, InterruptedException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.setJavaScriptEngine(new JavaScriptEngine(webClient));
        if (listener != null)
            webClient.setJavaScriptErrorListener(listener);

        HtmlPage page = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(timeout);
        Thread.sleep(timeout);
        webClient.setJavaScriptErrorListener(new JavaScriptErrorListener(){
            @Override
            public void scriptException(HtmlPage htmlPage, ScriptException e) {
                e.printStackTrace();
            }

            @Override
            public void timeoutError(HtmlPage htmlPage, long l, long l1) {

            }

            @Override
            public void malformedScriptURL(HtmlPage htmlPage, String s, MalformedURLException e) {
                e.printStackTrace();
            }

            @Override
            public void loadScriptError(HtmlPage htmlPage, URL url, Exception e) {
                e.printStackTrace();
            }
        });
        return page;
    }
}
