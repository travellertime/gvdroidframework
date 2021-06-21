package com.gvdroidframework.logging.sensitive;

import com.alibaba.fastjson.serializer.ValueFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Order(-2000)
@Slf4j
public class ValueDesensitizeFilter implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        if (!(value instanceof String) || ((String) value).length() == 0) {
            return value;
        }
        try {
            Field field = object.getClass().getDeclaredField(name);
            Desensitization desensitization;
            if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
                return value;
            }
            List<String> regular;
            DesensitionType type = desensitization.type();
            switch (type) {
                case CUSTOM:
                    regular = Arrays.asList(desensitization.attach());
                    break;
                case TRUNCATE:
                    regular = truncateRender(desensitization.attach());
                    break;
                default:
                    regular = Arrays.asList(type.getRegular());
            }
            if (regular.size() > 1) {
                String match = regular.get(0);
                String result = regular.get(1);
                if (null != match && result != null && match.length() > 0) {
                    return ((String) value).replaceAll(match, result);
                }
            }
        } catch (NoSuchFieldException e) {
            log.warn("ValueDesensitizeFilter the class {} has no field {}", object.getClass(), name);
        }
        return value;
    }

    private List<String> truncateRender(String[] attachs) {
        List<String> regular = new ArrayList<>();
        if (null != attachs && attachs.length >1) {
            String rule = attachs[0];
            String size = attachs[1];
            String template, result;
            if ("0".equals(rule)) {
                template = "^(\\S{%s})(\\S+)$";
                result = "$1";
            } else if ("1".equals(rule)) {
                template = "^(\\S+)(\\S{%s})$";
                result = "$2";
            } else {
                return regular;
            }
            try {
                if (Integer.parseInt(size) > 0) {
                    regular.add(0, String.format(template, size));
                    regular.add(1, result);
                }
            } catch (Exception e) {
                log.warn("ValueDesensitizeFilter truncateRender size {} exception", size);
            }
        }
        return regular;
    }
}
