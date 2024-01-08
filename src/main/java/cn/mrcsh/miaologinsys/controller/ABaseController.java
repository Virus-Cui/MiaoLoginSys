package cn.mrcsh.miaologinsys.controller;

import cn.mrcsh.miaologinsys.enums.ErrorCode;
import lombok.Data;

public class ABaseController {

    public class response {
        private Integer code;
        private String msg;
        private Object data;

        public Integer getCode() {
            return code;
        }

        public response setCode(Integer code) {
            this.code = code;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public response setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Object getData() {
            return data;
        }

        public response setData(Object data) {
            this.data = data;
            return this;
        }
    }

    public response success(){
        return new response().setCode(ErrorCode.SUCCESS.getCode()).setMsg(ErrorCode.SUCCESS.getMsg()).setData(null);
    }

    public response success(Object data){
        return new response().setCode(ErrorCode.SUCCESS.getCode()).setMsg(ErrorCode.SUCCESS.getMsg()).setData(data);
    }

    public response error(){
        return new response().setCode(ErrorCode.ERROR.getCode()).setMsg(ErrorCode.ERROR.getMsg()).setData(null);
    }

    public response error(ErrorCode errorCode){
        return new response().setCode(errorCode.getCode()).setMsg(errorCode.getMsg()).setData(null);
    }
}
