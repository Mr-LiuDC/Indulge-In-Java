package cn.alittler.sshbase.utils;

import java.util.UUID;

public class MyCommonUtils {
	
	/**
	 * 生成UUID
	 * @return UUID
	 */
	public static String MyUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
