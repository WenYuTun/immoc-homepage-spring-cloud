package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wyt
 * @description: 实现接口调用打印请求事件
 * @date: 2019/12/26
 * @version: 1.0
 */
@Component
@Slf4j
public class AccessLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        Long startTime = (Long) context.get("startTime");
        HttpServletRequest httpServletRequest = context.getRequest();
        String url = httpServletRequest.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;
        log.info("url:{},duration:{}", url, duration / 100);
        return null;
    }
}
