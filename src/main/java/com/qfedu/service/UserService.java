package com.qfedu.service;

import com.qfedu.dao.User;
import com.qfedu.vo.R;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/10/22 14:51
 */
public interface UserService {
    R login(User user);
}
