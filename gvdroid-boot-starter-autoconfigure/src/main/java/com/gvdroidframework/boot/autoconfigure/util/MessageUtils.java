package com.gvdroidframework.boot.autoconfigure.util;

import com.gvdroidframework.base.component.Context;
import com.gvdroidframework.base.component.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Locale;


/**
 * 国际化资源文件的配置
 *
 * @author Colin
 * @since 2.0.0
 */
@Component
public class MessageUtils {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    @Deprecated
    public static String getErrMsg(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

    @Deprecated
    public static String getErrMsg(String key, String... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args, locale);
    }

    public static String getErrMsg(String key, String languageTag) {
        Locale locale;
        if (StringUtils.isEmpty(languageTag)) {
            locale = Locale.forLanguageTag("en-US");
        } else {
            locale = Locale.forLanguageTag(languageTag);
        }
        return messageSource.getMessage(key, null, locale);
    }


    public static String getErrMsg(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

    public static String getErrMsg(String key, Locale locale, String... args) {
        return messageSource.getMessage(key, args, locale);
    }

    public static String getErrMsg(String key, Request<?> dto) {
        Locale locale = getLocale(dto);
        return messageSource.getMessage(key, null, locale);
    }


    public static String getErrMsg(String key, Request<?> dto, String... args) {
        Locale locale = getLocale(dto);
        return messageSource.getMessage(key, args, locale);
    }


    public static String getErrMsg(String key, Context context) {
        Locale locale = getLocale(context);
        return messageSource.getMessage(key, null, locale);
    }

    public static String getErrMsg(String key, Context context, String... args) {
        Locale locale = getLocale(context);
        return messageSource.getMessage(key, args, locale);
    }

    private static Locale getLocale(Request<?> dto) {
        String tag = dto.getContext().getLocale();
        Locale locale;
        if (tag == null || tag.equals("")) {
            locale = Locale.forLanguageTag("en-US");
        } else {
            locale = Locale.forLanguageTag(tag);
        }
        return locale;
    }

    private static Locale getLocale(Context context) {
        String tag = context.getLocale();
        Locale locale;
        if (StringUtils.isEmpty(tag)) {
            locale = Locale.forLanguageTag("en-US");
        } else {
            locale = Locale.forLanguageTag(tag);
        }
        return locale;
    }
}
