package cn.mrcsh.miaologinsys.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {
    // 用户ID
    @TableId
    private String userId;
    // 用户名
    private String userName;
    // 用户昵称
    private String userNick;
    // 用户密码
    private String password;
    // 邮箱
    private String email;
    // 注册状态
    private boolean registerStatus;
}
