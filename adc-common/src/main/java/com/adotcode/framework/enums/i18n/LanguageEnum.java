package com.adotcode.framework.enums.i18n;

import com.adotcode.framework.enums.IEnum;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;

/**
 * 国际化多语言枚举
 *
 * @author risfeng
 * @date 2019/07/30
 */
public enum LanguageEnum implements IEnum<String> {
  /**
   * 美式英文
   */
  LANGUAGE_EN_US("en_US", "application.language.en.us.display.name"),

  /**
   * 简体中文
   */
  LANGUAGE_ZH_CN("zh_CN", "application.language.zh.cn.display.name");

  /**
   * 分隔符
   */
  private static final String SPLIT_CHAR = "_";

  /**
   * 语言类型
   */
  private String language;

  /**
   * 显示名称
   */
  private String displayName;

  LanguageEnum(String language, String displayName) {
    this.language = language;
    this.displayName = displayName;
  }

  /**
   * 获取指定语言类型(如未匹配,则返回中文)
   *
   * @param language 语言类型
   */
  public static String getLanguageType(String language) {
    if (StringUtils.isEmpty(language)) {
      return LANGUAGE_ZH_CN.language;
    }
    for (LanguageEnum languageEnum : LanguageEnum.values()) {
      if (languageEnum.language.equalsIgnoreCase(language)) {
        return languageEnum.language;
      }
    }
    return LANGUAGE_ZH_CN.language;
  }

  /**
   * 获取lang编码，eg：en_US 返回：en
   *
   * @return lang eg：en
   */
  public String getLang() {
    return getLocale()[0];
  }

  /**
   * 获取lang编码，eg：en_US 返回：en
   *
   * @return lang eg：en
   */
  public String getCountry() {
    return getLocale()[1];
  }

  /**
   * 当前语言是否为本地语言
   *
   * @return true-是、false-否
   */
  public boolean currentLocale() {
    return language.equals(LocaleContextHolder.getLocale().toString());
  }

  /**
   * 获取lang和country编码，eg：en_US 返回：["en","US"]
   *
   * @return lang eg：["en","US"]
   */
  private String[] getLocale() {
    if (!language.contains(SPLIT_CHAR)) {
      return new String[]{language, ""};
    }
    return language.split(SPLIT_CHAR);
  }

  /**
   * 获取值
   *
   * @return {@link String}-枚举值
   */
  @Override
  public String getValue() {
    return language;
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

  /**
   * 获取枚举描述值
   *
   * @return {@link String}-枚举描述
   */
  @Override
  public String getDisplayName() {
    return displayName;
  }
}
