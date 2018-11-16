package team.yingyingmonster.ccbs.controller;

import com.google.zxing.WriterException;
import org.junit.Test;
import team.yingyingmonster.ccbs.controller.bean.CreateQRcodeAction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:44 2018/11/12
 * - 测试二维码生成类
 **/

public class CreateQRcodeTest {
    @Test
    public void test() throws IOException, WriterException {
        CreateQRcodeAction.createQrCode(new FileOutputStream(new File("d://testupload/qr.PNG")),"1",700,"PNG");
    }
}
