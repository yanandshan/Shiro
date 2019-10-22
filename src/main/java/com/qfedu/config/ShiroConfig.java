package com.qfedu.config;

import com.qfedu.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.apache.tomcat.jni.Mmap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/10/22 15:50
 */
@Configuration
public class ShiroConfig {
    @Bean
    //1、创建权限管理器对象
    public DefaultWebSecurityManager creatDWM(MyRealm myRealm){
        return new DefaultWebSecurityManager(myRealm);

    }
    //2、创建Shiro过滤器对象
    @Bean
    public ShiroFilterFactoryBean creatSFFB(DefaultWebSecurityManager webSecurityManager){
       //1、创建Shiro过滤器工厂对象
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //2、设置权限管理对象
        factoryBean.setSecurityManager(webSecurityManager);
        //3、设置常用的三个url页面
        //设置登录页面
        factoryBean.setLoginUrl("login.html");
        //设置登录成功之后跳转的页面
        factoryBean.setSuccessUrl("index.html");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("error.html");

        //4、设置拦截规则 anon：匿名访问 放行 谁都可以使用 authc:认证访问 必须登录才可以使用
        Map<String, String> map = new HashMap<>();
       //登录界面放行，登录接口放行，静态资源放行
        map.put("/login.html","anon");
        map.put("/api/user/login","anon");
        map.put("/static/medis/*","anon");

        map.put("/*","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;



    }
}
