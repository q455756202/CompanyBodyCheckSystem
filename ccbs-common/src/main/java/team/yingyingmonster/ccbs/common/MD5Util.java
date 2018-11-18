package team.yingyingmonster.ccbs.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Juer Whang <br/>
 * - project: NormalBidPrice_version_3
 * - create: 1:50 2018/8/28
 * -
 **/
public class MD5Util {
    private static final String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private static String byteToArrayString(byte b) {
        int ret = b;
        if (ret < 0) {
            ret += 256;
        }
        int iD1 = ret / 16;
        int iD2 = ret % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    private static String byteToString(byte[] bytes) {
        StringBuilder buffer = new StringBuilder();
        for (byte b : bytes) {
            buffer.append(byteToArrayString(b));
        }
        return buffer.toString();
    }

    public static String getMD5Code(String str) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 断言 digset 必定不为 null
        assert digest != null;
        // md.digest() 该函数返回值为存放哈希值结果的byte数组
        return byteToString(digest.digest(str.getBytes()));
    }

    public static String getSafeCode(Object... args) {
        StringBuffer buffer = new StringBuffer();

        for (Object obj: args)
            buffer.append(obj.toString());

        return CommonUtil.toBase64(MD5Util.getMD5Code(buffer.toString()).getBytes());
    }
}
