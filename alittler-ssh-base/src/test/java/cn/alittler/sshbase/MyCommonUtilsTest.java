package cn.alittler.sshbase;

import org.junit.Test;

import cn.alittler.sshbase.utils.MyCommonUtils;

public class MyCommonUtilsTest {

	@Test
	public void testMyUUID() {
		String myuuid = MyCommonUtils.MyUUID();
		System.out.println(myuuid);
		System.out.println(myuuid.toUpperCase());
	}

}
