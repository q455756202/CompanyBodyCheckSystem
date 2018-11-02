package team.yingyingmonster.ccbs.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 9:59 2018/10/31
 * - JSON 工具包,用于便捷的对JSON进行解析和转换.
 **/
public class JsonUtil {
    /**
     * 声明用于使用的常量Gson对象
     */
    private static final Gson
            NORMAL = new GsonBuilder().create(),
            PRETTY = new GsonBuilder().setPrettyPrinting().create(),
            SERIALIZE_NULL = new GsonBuilder().serializeNulls().create(),
            PRETTY_AND_SERIALIZE_NULL = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    /**
     * 声明枚举常量
     */
    public enum TYPE {
        NORMAL, PRETTY, SERIALIZE_NULL, PRETTY_AND_SERIALIZE_NULL
    }

    /**
     * 将一个bean转换为json
     * @param obj 目标bean
     * @param type 需要转换的json格式
     * @return 格式化的json文本
     */
    public static String beanToJson(Object obj, TYPE type) {
        Gson gson = NORMAL;
        switch (type) {
            case PRETTY:
                gson = PRETTY;
                break;
            case SERIALIZE_NULL:
                gson = SERIALIZE_NULL;
                break;
            case PRETTY_AND_SERIALIZE_NULL:
                gson = PRETTY_AND_SERIALIZE_NULL;
                break;
        }

        return gson.toJson(obj);
    }

    /**
     * 将一个json文本转换为bean
     * @param json 目标json
     * @param clazz 目标bean的类型
     * @param <T> 目标bean的类型
     * @return 转换后的bean对象
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        return NORMAL.fromJson(json, clazz);
    }
}
