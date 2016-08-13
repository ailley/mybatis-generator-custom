package com.h.common;

public class StringUtil
{
  public static String splitLast(String str, String regex)
  {
    String[] split = str.split(regex);
    return split[(split.length - 1)];
  }

  public static boolean isEmpty(String str)
  {
    return (str == null) || (str.isEmpty());
  }

  public static boolean isNotBlank(String str)
  {
    return (str != null) && (!str.trim().isEmpty());
  }
}