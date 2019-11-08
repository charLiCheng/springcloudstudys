package com.charli.common.tools;

import com.charli.common.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description : web辅助类
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:13
 */
public final class WebUtil {
    private final static Logger logger = Logger.getLogger(WebUtil.class);
    private static final String UNKNOWN = "unknown";
    private static final String LOCAL_IP = "127.0.0.1";

    private WebUtil() {
    }


    /**
     * 获得参数Map
     *
     * @param request
     * @return
     */
    public static final Map<String, Object> getParameterMap(HttpServletRequest request) {
        Map<String, Object> params = WebUtils.getParametersStartingWith(request, null);
        Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            if (StringUtil.isBlank(params.get(key).toString())) {
                it.remove();
            }
        }
        return params;
    }

    /**
     * 获得参数Map
     *
     * @param request
     * @return
     */
    public static final String getUsername(HttpServletRequest request) {
        if (null == request) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            request = requestAttributes.getRequest();
        }
        HttpSession session = request.getSession();
        if (null == session.getAttribute("username")) {
            return null;
        }
        return session.getAttribute("username").toString();
    }

    /**
     * 获取客户端IP
     */
    public static final String getHost(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (LOCAL_IP.equals(ip)) {
            InetAddress inet = null;
            try { // 根据网卡取本机配置的IP
                inet = InetAddress.getLocalHost();
                ip = inet.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > Constant.INT_FIFTEEN) {
            if (ip.indexOf(Constant.COMMA_CHART) > 0) {
                ip = ip.substring(0, ip.indexOf(Constant.COMMA_CHART));
            }
        }
        return ip;
    }

}
