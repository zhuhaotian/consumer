/**
 * <pre>项目名称:maven_dmo 
 * 文件名称:Result.java 
 * 包名:com.jk.utils 
 * 创建日期:2018年12月21日下午6:49:40 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import lombok.Data;

/** 
 * <pre>项目名称：maven_dmo    
 * 类名称：Result    
 * 类描述：    
 * 创建人：yjm   
 * 创建时间：2018年12月21日 下午6:49:40    
 * 修改人：yjm    
 * 修改时间：2018年12月21日 下午6:49:40    
 * 修改备注：       
 * @version </pre>    
 */
@Data
public class Result {
	//返回给前台的状态码
	private Integer code;
	
	private String msg;
	
	private Object data;
	
	private boolean state=true;

}
