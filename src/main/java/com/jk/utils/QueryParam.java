/**
 * <pre>项目名称:maven_dmo 
 * 文件名称:QueryParam.java 
 * 包名:com.jk.utils 
 * 创建日期:2018年12月17日下午10:10:30 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import lombok.Data;

/** 
 * <pre>项目名称：maven_dmo    
 * 类名称：QueryParam    
 * 类描述：    
 * 创建人：yjm   
 * 创建时间：2018年12月17日 下午10:10:30    
 * 修改人：yjm    
 * 修改时间：2018年12月17日 下午10:10:30    
 * 修改备注：       
 * @version </pre>    
 */
@Data
public class QueryParam {

    private String phone_no;//发送验证码的手机号
	
    private String verify_code;//用户输入的验证码
    
}
