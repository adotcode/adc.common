package com.adotcode.framework.enums.application;

import com.adotcode.framework.enums.IEnum;
import lombok.Getter;

/**
 * 标识：是/否、启用/禁用等枚举
 *
 * @author risfeng
 * @date 2019/08/25
 */
@Getter
public enum YesOrNoEnum implements IEnum<Integer> {

  /**
   * 否/禁用
   */
  NO(0, "application.enum.application.yesOrNo.no"),

  /**
   * 是/启用
   */
  YES(1, "application.enum.application.yesOrNo.yes");

  /**
   * 枚举值
   */
  private Integer value;

  /**
   * 显示名称
   */
  private String displayName;

  YesOrNoEnum(Integer value, String displayName) {
    this.value = value;
    this.displayName = displayName;
  }

  @Override
  public Integer getValue() {
    return value;
  }

  /**
   * 获取枚举名称
   *
   * @return {@link String}-枚举名称
   */
  @Override
  public String getName() {
    return name();
  }


  @Override
  public String getDisplayName() {
    return displayName;
  }
}
