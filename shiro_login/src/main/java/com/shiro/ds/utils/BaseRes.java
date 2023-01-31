package com.shiro.ds.utils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.huajiao.platform.main.constant.Const;
//import com.huajiao.platform.main.util.Logs;
//import com.huajiao.platform.main.util.RestResult;
import com.shiro.ds.config.Constconfig;
import com.shiro.ds.pojo.RestResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

public class BaseRes {

    private static final long serialVersionUID = 6357869213649815390L;
    protected static ObjectMapper mapper = new ObjectMapper();
    protected static JsonFactory factory = mapper.getJsonFactory();

    protected void writeJSON(HttpServletResponse response, String json) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void writeJSON(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
        responseJsonGenerator.writeObject(obj);
        String s = "fnsln";


    }



    /**
     * 得到ModelAndView
     */
    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }



    public void logBefore(String interfaceName) {

//        Logs.Console.info("");
//        Logs.Console.info("start");
        System.out.println(interfaceName + " --- " + getRequest().getSession().getAttribute(Constconfig.SESSION_USER));
    }

    public void logAfter() {
//        Logs.Console.info("end");
//        Logs.Console.info("");
    }

    public static RestResult render(int errno, String errmsg, Object data) {
        return new RestResult(errno, errmsg, data);
    }

    public RestResult success() {
        return new RestResult(0, "success");
    }

    public RestResult success(Object data) {
        return new RestResult(0, "success", data);
    }

    public RestResult success(String errmsg, Object data) {
        return new RestResult(0, errmsg, data);
    }

    public RestResult fail() {
        return new RestResult(1099, "fail", null);
    }

    public RestResult fail(String msg) {
        return new RestResult(1099, msg, null);
    }

    public RestResult fail(int errno, String errmsg) {
        return new RestResult(errno, errmsg);
    }

    public RestResult fail(int errno, String errmsg, Object data) {
        return new RestResult(errno, errmsg, data);
    }

    /**
     * 获取当前请求用户的用户名
     * @return String
     */
    protected String getCurrentUser() {
        Object user = SecurityUtils.getSubject().getSession().getAttribute(Constconfig.SESSION_USER);
        return user == null ? "GUEST" : user.toString();
    }

}
