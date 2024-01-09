package cn.mrcsh.miaologinsys.enums;


public enum ErrorCode {
    SUCCESS(2000,"成功"),
    ERROR(5000,"服务器错误"),
    USERNAME_OR_PASSWORD_IS_NOT_CORRESPONDING(4001,"用户名密码错误"),
    USER_IS_NOT_CHECKED(4002,"用户邮箱未验证"),
    USER_IS_EXISTS(4003, "用户名已经存在"),
    EMAIL_ACCESSED(4005,"邮箱已经验证")
    ;
    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
