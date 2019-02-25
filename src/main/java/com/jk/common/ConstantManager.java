package com.jk.common;

import java.net.URLEncoder;

/**
 * @Auther: yjm
 * @Date: 2019/2/25 09:45
 * @Description:
 */
public class ConstantManager {
    //用户详细信息
    public static final String OAUTH_USER_INFO="snsapi_userinfo";
    public static final String OAUTH_QQ_USER_INFO="get_user_info";
    //静默授权
    public static final String OAUTH_USER_BASE="snsapi_base";
    public static final String GRANT_TYPE="authorization_code";

    //网页授权作用域
    public static final String OAUTH_WEB_LOGIN="snsapi_login";
    public static final String PC="pc"; public static final String WAP="wap";
    /** * QQ登录回调 */
    public static final String QQCALLBACKURL = URLEncoder.encode("http://www.sucaiku.xin/callback/getQqCallback");

}
