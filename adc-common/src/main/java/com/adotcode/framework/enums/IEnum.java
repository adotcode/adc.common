package com.adotcode.framework.enums;

/**
 * 枚举规范接口
 *
 * @author risfeng
 * @date 2019/12/15
 */
public interface IEnum<TValue> {

  /**
   * 获取值
   *
   * @return {@link TValue}-枚举值
   */
  TValue getValue();

  /**
   * 获取枚举名称
   *
   * @return {@link String}-枚举名称
   */
  String getName();

  /**
   * 获取枚举描述值
   *
   * @return {@link String}-枚举描述
   */
  String getDisplayName();
}
