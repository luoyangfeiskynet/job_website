package cn.com.stone.core.common;

import java.util.UUID;

public class TokenGeneratorUtil {
	
	
	/**
    * 生成一个UUID串（32个字符，其中的字母为小写）
    * @return
    * @throws
    */
   public static String genUUID() {
       return UUID.randomUUID().toString().replaceAll("-", "");
   }
	
	public static String tokenGenerator(){
		return genUUID();
	}
	public static void main(String[] args) {
		System.out.println(TokenGeneratorUtil.tokenGenerator());;
	}
	
	
	
}
