package com.adotcode.framework.enums.application;

import com.adotcode.framework.enums.IEnum;
import lombok.Getter;

/**
 * 性别
 *
 * @author risfeng
 * @date 2019/08/25
 */
@Getter
public enum GenderEnum implements IEnum<Integer> {
  /**
   * 未知
   */
  UNKNOWN(0, "application.enum.application.gender.unknown"),
  /**
   * 男
   */
  Male(1, "application.enum.application.gender.male"),
  /**
   * 女
   */
  FEMALE(2, "application.enum.application.gender.female"),
  /**
   * 女变男
   */
  FEMALE_TO_MALE(5, "application.enum.application.gender.femaleToMale"),
  /**
   * 男变女
   */
  MALE_TO_feMALE(6, "application.enum.application.gender.maleToFemale"),
  /**
   * 未说明的
   */
  UNSPECIFIED(9, "application.enum.application.gender.unspecified");

  /**
   * 值
   */
  private Integer value;

  /**
   * 显示名称
   */
  private String displayName;

  GenderEnum(Integer value, String displayName) {
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
