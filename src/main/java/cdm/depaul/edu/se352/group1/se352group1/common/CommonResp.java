package cdm.depaul.edu.se352.group1.se352group1.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import cdm.depaul.edu.se352.group1.se352group1.common.enums.ErrCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResp<T> {

    private String code;

    private String msg;

    private T obj;

    public CommonResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> CommonResp<T> ok(T data) {
        CommonResp<T> response = new CommonResp<T>();
        response.setCode(ErrCodeEnum.SUCCESS.getCode());
        response.setMsg(ErrCodeEnum.SUCCESS.getDesc());
        response.setObj(data);
        return response;
    }

    public static <T> CommonResp<T> ok() {
        CommonResp<T> response = new CommonResp<T>();
        response.setCode(ErrCodeEnum.SUCCESS.getCode());
        response.setMsg(ErrCodeEnum.SUCCESS.getDesc());
        return response;
    }

    public static <T> CommonResp<T> fail(ErrCodeEnum err , ErrCodeEnum msg, T data) {
        CommonResp<T> response = new CommonResp<T>();
        response.setCode(err.getCode());
        response.setMsg(msg.getCode());
        response.setObj(data);
        return response;
    }
}
