package com.rdc.util;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * GeetestWeb配置文件
 *
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "03c3549d0e94793dcf3ad279a9a7005b";
	private static final String geetest_key = "68abfc4381d5e5f05f0f02403b09ca09";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}

	public static final boolean isnewfailback() {
		return newfailback;
	}

}
