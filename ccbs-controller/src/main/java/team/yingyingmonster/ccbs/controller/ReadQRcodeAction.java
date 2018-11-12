package team.yingyingmonster.ccbs.controller;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Bill;
import team.yingyingmonster.ccbs.database.bean.Doctor;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.BillMapperWeng;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.CheckMapperWeng;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.DoctorMapperWeng;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.UserMapperWeng;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyCheckSystem
 * - create: 21:03 2018/10/30
 * - 读取二维码信息的类
 **/

@Controller
@RequestMapping("/read-qr-code")
public class ReadQRcodeAction {
    public static final String FORMAT = "png";
    public static final String CHARTSET = "utf-8";
    @Autowired
    private UserMapperWeng userMapperWeng;
    @Autowired
    private DoctorMapperWeng doctorMapperWeng;
    @Autowired
    private CheckMapperWeng checkMapperWeng;
    @Autowired
    private BillMapperWeng billMapperWeng;
    /**
     * 读取二维码信息
     * @param
     * @return
     */
    @RequestMapping("/get-qr-result")
    @ResponseBody
    public Map getQRresult(@RequestParam(value = "uploadUserCode" , required = true)MultipartFile uploadUserCode, HttpSession session) throws IOException {
        User user = null;
        Doctor doctor = null;
        List<Bill> bills = null;
        Map<String,Object> map = new HashMap<>();
        String path="D:/testupload/"+uploadUserCode.getOriginalFilename();
        File file = new File(path);
        File fileParent = file.getParentFile();
        if (!fileParent.exists()){
            fileParent.mkdir();
        }
        //上传
        uploadUserCode.transferTo(file);
        Result result=QRresult(path);
        if (result != null) {
            if (result.getText() != null) {
                Long userId = Long.valueOf(result.getText());
                user = userMapperWeng.selectUserByUserId(userId);
                Long accountid = ((Account)session.getAttribute("login-account")).getAccountid();
                doctor = doctorMapperWeng.selectDeptByAccountId(accountid);//获取部门id和名字
                bills = billMapperWeng.selectByDeptIdAndUserId(doctor.getDeptByDeptid().getDeptid(),userId);
                map.put("user",user);
                map.put("bills",bills);
            }
        }

        return map;
    }

    public Result QRresult(String filePath){

        Result result = null;
        try {
            File file = new File(filePath);
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap bitmap = new BinaryBitmap(
                    new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            HashMap hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
            result = new MultiFormatReader().decode(bitmap, hints);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.google.zxing.NotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
