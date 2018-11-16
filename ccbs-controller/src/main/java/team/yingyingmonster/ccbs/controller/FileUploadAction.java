package team.yingyingmonster.ccbs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import team.yingyingmonster.ccbs.common.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 10:16 2018/11/7
 * - 用于文件上传
 **/
@Controller
@RequestMapping("/upload")
public class FileUploadAction {
    protected Logger logger = Logger.getLogger(FileUploadAction.class);

    @RequestMapping("/uploadsumaryimage")
    public void uplodaImg(@RequestParam("upload") MultipartFile file,
                          HttpServletRequest request,
                          HttpServletResponse response)
    {
        try {
            PrintWriter out = response.getWriter();
            String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
            String uploadContentType = file.getContentType();
            if (file.getSize() > 1024 * 50) {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction("
                        + CKEditorFuncNum + ",''," + "'文件大小不得大于50kb');");
                out.println("</script>");
                return;
            }
            // 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction("
                    + CKEditorFuncNum + ",'data:image/"+uploadContentType+";base64,"+CommonUtil.toBase64(file.getBytes()) +"','')");
            out.println("</script>");
            return;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
