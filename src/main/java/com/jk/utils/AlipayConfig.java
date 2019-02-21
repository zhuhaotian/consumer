package com.cun.config;

/**
 * 支付宝配置信息
 * @author linhongcun
 *
 */
public class AlipayConfig {

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    public static String app_id = "0123456789";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    public static String private_key = "abcdefghijklmnopqrstuvwxyz0123456789";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/returnUrl";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    public static String public_key = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String signtype = "RSA2";

}

