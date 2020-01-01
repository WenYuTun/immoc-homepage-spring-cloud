package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author wyt
 * @description: 在过滤器中存储客户端发起请求的时间戳
 * @date: 2019/12/26
 * @version: 1.0
 */
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * 指定过滤器类型
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 指定过滤器顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否启用
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     */
    @Override
    public Object run() throws ZuulException {
        //请求上下文，用于在过滤器之间传递消息
        RequestContext context = RequestContext.getCurrentContext();
        context.set("startTime",System.currentTimeMillis());
        return null;
    }
}
