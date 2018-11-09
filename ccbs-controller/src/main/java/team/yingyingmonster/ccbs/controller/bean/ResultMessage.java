package team.yingyingmonster.ccbs.controller.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 14:30 2018/10/31
 * -
 **/
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultMessage {
    private static final Integer
            SUCCESSFUL  = 200,  // 当执行成功时,返回该值.
            ERROR       = 400;  // 当执行失败时,返回该值.

    private Integer resultState = 400;  // 响应的返回值状态.
    private String  resultMessage;      // 响应的返回值信息.
    private Object  resultData;         // 响应的返回值数据.

    private ResultMessage(Integer resultState, String resultMessage, Object resultData) {
        this.resultState = resultState;
        this.resultMessage = resultMessage;
        this.resultData = resultData;
    }

    /**
     * 获取一条响应成功的信息
     * @param message 欲返回的信息值.
     * @param data 欲返回的数据,如果是图片,需要先转换为 byte[] 再传入,前端使用base64的方式解析图片.
     * @return 组装完成的信息.
     */
    public static ResultMessage createSuccessMessage(String message, Object data) {
        return new ResultMessage(SUCCESSFUL, message, data);
    }

    /**
     * 获取一条响应失败的信息
     * @param message 欲返回的信息值.
     * @param data 欲返回的数据,如果是图片,需要先转换为 byte[] 再传入,前端使用base64的方式解析图片.
     * @return 组装完成的信息.
     */
    public static ResultMessage createErrorMessage(String message, Object data) {
        return new ResultMessage(ERROR, message, data);
    }
}
