package com.likui.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ClassName: MyErrorAttributes
 * @Description: 在容器中加入自定义的 ErrorAttributes
 * @Author: LiKui
 * @Date: 2019-9-10 17:44
 * @Version: 1.0
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("autho","likui");
        return errorAttributes;
    }
}