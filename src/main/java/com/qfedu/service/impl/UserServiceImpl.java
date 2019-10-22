package com.qfedu.service.impl;

import com.qfedu.dao.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.R;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/10/22 14:52
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public R login(User user) {

        if (user.getUsername().equals("admin")&&user.getPsw().equals("admin") ) {

            //登录成功的话
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPsw());
            subject.login(token);
            return R.setOK("OK");
        } else {
            return R.setERROR();
        }
    }
}
