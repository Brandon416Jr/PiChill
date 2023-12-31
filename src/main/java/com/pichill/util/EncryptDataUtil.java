package com.pichill.util;

import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptDataUtil {
	public static final String encrypt_data_prefix = "PC_";
	public static final String AES_KEY_STRING = "1A2320F02199E6DD4D009E03FBEACF90";
	private static Logger logger = LoggerFactory.getLogger(EncryptDataUtil.class);

	/**
	 * 解密数据
	 *
	 * @param content
	 * @return
	 */
	public static String decryptData(String content) {
		try {
			if (StringUtils.isEmpty(content)) {
				return content;
			}
			if (StringUtils.startsWith(content, encrypt_data_prefix)) {
				return AES.decrypt(content.substring(encrypt_data_prefix.length()), AES_KEY_STRING);
			}
			return content;
		} catch (Exception e) {
			logger.error("解密数据发生错误" + content, e);
			return content;
		}
	}

	/**
	 * 加密数据
	 *
	 * @param content
	 * @return
	 */
	public static String encryptData(String content) {
		try {
			if (StringUtils.isEmpty(content)) {
				return content;
			}
			if (StringUtils.startsWith(content, encrypt_data_prefix)) {
				return content;
			}
			return encrypt_data_prefix + AES.encrypt(content, AES_KEY_STRING);
		} catch (Exception e) {
			logger.error("加密数据发生错误" + content, e);
			return content;
		}
	}

}
