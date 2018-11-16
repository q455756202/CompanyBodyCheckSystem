package team.yingyingmonster.ccbs.controller;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.JsonObject;
import com.lowagie.text.DocumentException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.aop.annotation.Namespace;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.UserCheck;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerUser;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerCompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserCheckMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.GuideShowService;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;
import team.yingyingmonster.ccbs.template.PdfUtil;
import team.yingyingmonster.ccbs.web.WebUtil;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:29 2018/11/9
 * - 导检单展示模块
 **/
@Controller
@RequestMapping("/guide-show")
public class GuideShowAction {
    @Autowired
    private GuideShowService guideShowService;
    @Autowired
    private JuerCompanyMapper juerCompanyMapper;
    @Autowired
    private JuerUserMapper juerUserMapper;
    @Autowired
    private JuerUserCheckMapper juerUserCheckMapper;
    @Autowired
    private JuerCompanyCheckSystemService juerCompanyCheckSystemService;

    @RequestMapping("/index")
    public String index() {
        return "guide-show/success";
    }

    @RequestMapping("/render")
    public String render() {
        return "guide-show/render-page";
    }

    @RequestMapping("/get-guide-list")
    @ResponseBody
    public ResultMessage getGuide(HttpSession session) {
        Long accountid = ((Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid();
        return ResultMessage.createSuccessMessage(
                "success!",
                guideShowService.getTeamformList(
                        juerCompanyMapper.selectCompanyByAccountId(accountid).getCompanyid()
                ));
    }

    @RequestMapping("/get-user-list")
    @ResponseBody
    public ResultMessage getCheckUserList(Long teamformid, HttpSession session) {
        Long companyid = juerCompanyMapper.selectCompanyByAccountId(((Account) session.getAttribute(Constant.SESSION_LOGIN_ACCOUNT)).getAccountid()).getCompanyid();
        List<JuerUser> list = juerCompanyCheckSystemService.getJuerUsersByTeamformId(teamformid);
//        System.out.println(JsonUtil.beanToJson(list, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
        return ResultMessage.createSuccessMessage(
                "success!",
                list
        );
    }

    @RequestMapping("/get-user-check")
    @ResponseBody
    public ResultMessage getUserCheck(Long usercheckid) {
        return ResultMessage.createSuccessMessage("success!", juerUserCheckMapper.selectUserCheckByUsercheckid(usercheckid));
    }

    @RequestMapping("/get-user-qrcode")
    @ResponseBody
    public ResultMessage getUserQrcode(@RequestBody UserCheck userCheck) {
        byte[] array = juerCompanyCheckSystemService.getUserQrcodeByteArray(userCheck);
        if (array != null)
            return ResultMessage.createSuccessMessage("success!", array);
        else
            return ResultMessage.createErrorMessage("error!");
    }

    @RequestMapping("/get-qrcode-data")
    @ResponseBody
    public ResultMessage getQrcodeData(@RequestBody String base64) {
        byte[] array = Base64.decodeBase64(base64);
        String str = new String(array);
        return ResultMessage.createSuccessMessage("success!", JsonUtil.jsonToBean(str, JsonObject.class));
    }

    @RequestMapping("/download-pdf")
    public ResponseEntity<byte[]> downloadPdf(@RequestBody String url) throws DocumentException, IOException, InterruptedException {
        System.out.println("downloadPdf! url='" + url.substring(4) + "'");
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            HtmlPage page = WebUtil.getAjaxHtml("http://"+URLDecoder.decode(url.substring(4), "UTF-8"), 5000, null);
            PdfUtil.createPdfFromHtmlString(page.asXml(), outputStream);
            System.out.println(page.asXml());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", page.getTitleText()+".pdf");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.CREATED);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
