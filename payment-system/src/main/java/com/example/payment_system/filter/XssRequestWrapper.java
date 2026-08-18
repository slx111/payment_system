package com.example.payment_system.filter;

import org.apache.commons.text.StringEscapeUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XssRequestWrapper extends HttpServletRequestWrapper {

    public XssRequestWrapper(HttpServletRequest request) {
        super(request); // 调用父类构造函数，传入原始请求
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value == null) return null;
        // 对单个参数值进行 HTML 转义
        return StringEscapeUtils.escapeHtml4(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values == null) return null;
        // 对参数值数组中的每一个元素进行转义
        for (int i = 0; i < values.length; i++) {
            values[i] = StringEscapeUtils.escapeHtml4(values[i]);
        }
        return values;
    }
}