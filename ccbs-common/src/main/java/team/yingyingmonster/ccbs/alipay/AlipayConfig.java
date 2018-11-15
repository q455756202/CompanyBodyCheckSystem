package team.yingyingmonster.ccbs.alipay;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:20 2018/11/14
 * - 支付宝支持
 **/

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092000556167";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC8BdEijyVOvA/2ilEeq884Lv8EDZDa8tPBDdGDqHvUoW5k+vRp6Wpx82DEmtLe79ZU2AKQiQ9/7Pra99aw6nJhIor/PEd7mq4njmyYOHfqiN2a7oLIYDhseywT9rjoeLOjB0LVRywUgOqFW7mNbPEXIr3zpoYVMgncIA6rCXVYgGNqCxxbz4fRjCrup8d5aAVgSFJ/rkGVESOT0RgJd14KK9SXJdo7uY8/i/Vk4qiT1f4HylmQVYYzFnPu+TTYEFXJgnNWi6ulgW71T0k/8ITmW7NNKsn8iX1gZ9EGnhP1mz5WoM1xwJC7Nd1Y30XaKQAD2koH5bD6ulh1AYOCcwPPAgMBAAECggEAAu3gRTaPsTtS0Fd1ThIFJ23sASco85BG5kIN2ow8aaKeMqqKNkAxrVbKUiXLVTfNUgMPfyrzd928Rr8HtDfi0kqUecd5oZ5WSj14yaJPk/LP6QMAPJjrKB1/IUx9svl2avrI+sOiFyuu+6bjLCXfV6nt5abZfekKqEhDkjySfG90xuTkxZHCyVx7E2zOe83Wgm5Kgyfrma1TmDHsqkCnq3+YndWOrGXeKlHZnevE8V15CgMK6j08Fknr6cYTM7xuXfNYvOzi93keftT2taENypG59U/RnIxEMkQ2aEV5guUwtLcXjCIurs2LWfnXAcnsJ5nfYLycJkiu5Su8hyhd8QKBgQDeFdkE1xxZfoky1sbNtUMrQAnK1qHP89qP6eMwa7bJbtTRFa7n6OU2V6M+0IsgKkMAJ9A3GcuIz5n7Zk0L+uCwz7nBNv4qqEQ62VwxvvHmWFJ8J0eiSyWnUbf9QmXt7KGtg2+umB5f+9YRlMEt1UZodXW6LL9RE+ds2kZB8+bcCQKBgQDYvFVHSuW9doyDRktPXUMcwQPfTiyZWMTtC5Xul6eGxybYBU6zprCaDMNeoQhVuvVt1OydAGfO3xigulIm588V9hhBudlAtgJJ73RVycRX8TJ0UVH/u/OSObXtOFbK7Peo61AlUAxMFNFXC0c39JrlZ0V5462MjxvW1H4nAWkHFwKBgQDUx6v5JjykRkcfbYZmeyAS5TU8oW3Bd0tWDWo970XfMxA2D4dX7N0HtunSei6CL9un331v/Yfz2awXoYl6S/FRloTL6WuV5UgR9kWN5/uOjdrh1yScC1HVQMd+oEpWrhytyTuM1XRs1DXi/FomFqxx0vBr4wmenepicbNU52GuOQKBgQCfrBA/l6QtstrOE8mDzLeWxXQu3Y7p4oYiBPkOb9fR6YJqf2591/4fX+vHGWfkkPojUkyHVjckJyQjtWC0nO7pxQYV1e+CRxTkl27jjOQDzgRXwVlhyHwnbDDldS4sDexfHA1Nj+2fV27qa7qqNKCxBSYgKGZBOWVPHflajyVrPQKBgH+iKvq/ymg8J26BtD9YdZQGIvowUpTaSoadQqa/jCCPLjL+XrQvDAnKP26OVny9D7c1zxbte9EPmOjCOU81RIxRuQJC7RRCRIJIhU/59uwC+r0tSOyYId4fY6WaFtvnd9yU4CbhMvIxUR9e+PhBgwr6cbW/PV4vZVYyP2i1F2LH";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvAXRIo8lTrwP9opRHqvPOC7/BA2Q2vLTwQ3Rg6h71KFuZPr0aelqcfNgxJrS3u/WVNgCkIkPf+z62vfWsOpyYSKK/zxHe5quJ45smDh36ojdmu6CyGA4bHssE/a46HizowdC1UcsFIDqhVu5jWzxFyK986aGFTIJ3CAOqwl1WIBjagscW8+H0Ywq7qfHeWgFYEhSf65BlREjk9EYCXdeCivUlyXaO7mPP4v1ZOKok9X+B8pZkFWGMxZz7vk02BBVyYJzVourpYFu9U9JP/CE5luzTSrJ/Il9YGfRBp4T9Zs+VqDNccCQuzXdWN9F2ikAA9pKB+Ww+rpYdQGDgnMDzwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
