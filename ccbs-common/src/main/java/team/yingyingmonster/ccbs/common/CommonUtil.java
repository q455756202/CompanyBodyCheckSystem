package team.yingyingmonster.ccbs.common;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 14:31 2018/10/29
 * - 通用工具包,里面提供了一些我自己写的工具,比如说批量判断是否为空等等等.
 **/
public class CommonUtil {
    /**
     * 判断对象是否为空.
     * @param obj
     * @return 为true时则obj为空.
     */
    public static boolean isNull(Object obj) {
        if (obj instanceof String)
            return ((String) obj).isEmpty();
        return obj == null;
    }

    /**
     * 批量判断对象是否为空,可以传入多个参数.
     * @param objs 参数列表
     * @return 如果都不为空,则返回-1,否则返回为空的参数索引.只返回第一个空参数索引.
     */
    public static int isNull(Object... objs) {
        int result = -1;

        for (int i = 0; i < objs.length; i++)
            if (isNull(objs[i])) {
                result = i;
                break;
            }

        return result;
    }
}
