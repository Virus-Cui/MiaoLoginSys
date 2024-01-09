package cn.mrcsh.miaologinsys.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.mrcsh.miaologinsys.entity.po.User;
import cn.mrcsh.miaologinsys.mapper.UserMapper;
import cn.mrcsh.miaologinsys.service.MailService;
import cn.mrcsh.miaologinsys.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailService mailService;

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username)
                        .eq("password",password);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean checkExists(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        return userMapper.selectOne(queryWrapper) != null;
    }

    @Override
    @Transactional
    public void createNewAccount(User user) {
        user.setUserId(IdUtil.getSnowflakeNextIdStr());
        user.setRegisterStatus(false);
        userMapper.insert(user);
        // 发送邮件
        mailService.sendEmail(user.getEmail(), String.format("""
                请点击以下链接启用账号
                %s
                """, "http://localhost:5173/ca?id="+user.getUserId()));
    }

    @Override
    @Transactional
    public User checkAccount(String userId) {
        User user = userMapper.selectById(userId);
        if(user != null){
            user.setRegisterStatus(true);
            userMapper.updateById(user);
        }
        return user;
    }
}
