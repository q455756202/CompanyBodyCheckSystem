package team.yingyingmonster.ccbs.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:36 2018/11/2
 * - 通用的消息类，所有的请求返回该对象。
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultMessage {
    public static final Integer
            SUCCESS = 200,
            ERROR   = 400;

    private Integer state;
    private String message;
    private Object data;

    private ResultMessage(Integer state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    /**
     * 构建一条执行成功（SUCCESS : 200）的响应消息。
     * @param message 响应信息。
     * @param data 响应数据。
     * @return 信息对象。
     */
    public static ResultMessage createSuccessMessage(String message, Object data) {
        return new ResultMessage(SUCCESS, message, data);
    }

    /**
     * 构建一条执行失败（ERROR : 400）的响应信息。
     * @param message 响应信息。
     * @return 信息对象。
     */
    public static ResultMessage createErrorMessage(String message) {
        return new ResultMessage(ERROR, message, null);
    }
}
