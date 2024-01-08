package cn.mrcsh.miaologinsys.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.mrcsh.miaologinsys.entity.po.User;
import cn.mrcsh.miaologinsys.enums.ErrorCode;
import cn.mrcsh.miaologinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController extends ABaseController{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public response login(String username, String password){
        User login = userService.login(username, password);
        if(login == null){
            return error(ErrorCode.USERNAME_OR_PASSWORD_IS_NOT_CORRESPONDING);
        }else if(!login.isRegisterStatus()){
            return error(ErrorCode.USER_IS_NOT_CHECKED);
        }else {
            StpUtil.login(login.getUserId());
            String tokenValue = StpUtil.getTokenInfo().tokenValue;
            return success(tokenValue);
        }
    }

    @PostMapping("/register")
    public response register(@RequestBody User user){
        // 查询数据库是否有用户名一致的用户
        boolean exists = userService.checkExists(user.getUserName());
        if(exists){
            return error(ErrorCode.USER_IS_EXISTS);
        }
        userService.createNewAccount(user);
        return null;
    }

    @GetMapping("/checkAccount/{userId}")
    public void checkAccount(HttpServletResponse response, @PathVariable String userId) throws IOException {
        User user = userService.checkAccount(userId);
        if(user != null){
            response.getWriter().write("SUCCESS");
        }else {
            response.getWriter().write("NOT EXISTS");
        }
    }

}
