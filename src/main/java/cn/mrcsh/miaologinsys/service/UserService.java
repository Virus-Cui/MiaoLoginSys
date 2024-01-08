package cn.mrcsh.miaologinsys.service;

import cn.mrcsh.miaologinsys.entity.po.User;

public interface UserService {
    User login(String username, String password);

    boolean checkExists(String userName);

    void createNewAccount(User user);

    User checkAccount(String userId);
}
