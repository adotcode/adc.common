package com.adotcode.framework.util.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Spring Boot 注入Bean工具类
 *
 * @author risfeng
 * @date 2020/02/08
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(@Nullable ApplicationContext applicationContextParameter)
      throws BeansException {
    applicationContext = applicationContextParameter;
  }

  public static Object getObject(String name) {
    return applicationContext.getBean(name);
  }

  public static <T> T getObject(Class<T> tClass) {
    return applicationContext.getBean(tClass);
  }

  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }

  public <T> T getBean(Class<T> tClass) {
    return applicationContext.getBean(tClass);
  }
}
