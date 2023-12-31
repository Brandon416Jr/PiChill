package com.pichill.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	// /** 算法/模式/填充 **/
	private static final String CipherMode = "AES/ECB/PKCS5Padding";

	/**
	 * 生成一个AES密钥对象
	 *
	 * @return
	 */
	public static SecretKeySpec generateKey() {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom());
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			return key;
		} catch (NoSuchAlgorithmException e) {
			// logger.error("没有AES加密算法", e);
			throw new RuntimeException("没有AES加密算法", e);
		}
	}

	/**
	 * 生成一个AES密钥字符串
	 *
	 * @return
	 */
	public static String generateKeyString() {
		return byte2hex(generateKey().getEncoded());
	}

	/**
	 * 加密字节数据
	 *
	 * @param content
	 * @param key
	 * @return
	 */
	public static byte[] encrypt(byte[] content, byte[] key) {
		try {
			Cipher cipher = Cipher.getInstance(CipherMode);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			// logger.error("加密字节数据发生错误", e);
			throw new RuntimeException("加密字节数据失败", e);
		}
	}

	/**
	 * 通过byte[]类型的密钥加密String
	 * 
	 * @param content
	 * @param key
	 * @return 16进制密文字符串
	 */
	public static String encrypt(String content, byte[] key) {
		try {
			Cipher cipher = Cipher.getInstance(CipherMode);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
			byte[] data = cipher.doFinal(content.getBytes("UTF-8"));
			String result = byte2hex(data);
			return result;
		} catch (Exception e) {
			// logger.error("通过byte[]类型的密钥加密String发生错误", e);
			throw new RuntimeException("通过byte[]类型的密钥加密String加密失败", e);
		}
	}

	/**
	 * 通过String类型的密钥加密String
	 *
	 * @param content
	 * @param key
	 * @return 16进制密文字符串
	 */
	public static String encrypt(String content, String key) {
		if (content == null || content.length() == 0) {
			return content;
		}
		byte[] data = null;
		try {
			data = content.getBytes("UTF-8");
		} catch (Exception e) {
			// logger.error("通过String类型的密钥加密String发生错误", e);
			throw new RuntimeException("通过String类型的密钥加密String加密失败", e);
		}
		data = encrypt(data, new SecretKeySpec(hex2byte(key), "AES").getEncoded());
		String result = byte2hex(data);
		return result;
	}

	/**
	 * 通过byte[]类型的密钥解密byte[]
	 *
	 * @param content
	 * @param key
	 * @return
	 */
	public static byte[] decrypt(byte[] content, byte[] key) {
		try {
			Cipher cipher = Cipher.getInstance(CipherMode);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("通过byte[]类型的密钥解密byte[]失败", e);
		}
	}

	/**
	 * 通过String类型的密钥 解密String类型的密文
	 *
	 * @param content
	 * @param key
	 * @return
	 */
	public static String decrypt(String content, String key) {
		if (content == null || content.length() == 0) {
			return content;
		}
		byte[] data = null;
		try {
			data = hex2byte(content);
		} catch (Exception e) {
			throw new RuntimeException("解密hex失败");
		}
		data = decrypt(data, hex2byte(key));
		if (data == null)
			return null;
		try {
			return new String(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("通过String类型的密钥 解密String类型的密文失败", e);
		}
	}

	/**
	 * 通过byte[]类型的密钥 解密String类型的密文
	 *
	 * @param content
	 * @param key
	 * @return
	 */
	public static String decrypt(String content, byte[] key) {
		try {
			Cipher cipher = Cipher.getInstance(CipherMode);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
			byte[] data = cipher.doFinal(hex2byte(content));
			return new String(data, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException("通过byte[]类型的密钥 解密String类型的密文失败", e);
		}
	}

	/**
	 * 字节数组转成16进制字符串
	 *
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) { // 一个字节的数，
		StringBuffer sb = new StringBuffer(b.length * 2);
		String tmp;
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			tmp = (Integer.toHexString(b[n] & 0XFF));
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
		}
		return sb.toString().toUpperCase(); // 转成大写
	}

	/**
	 * 将hex字符串转换成字节数组
	 *
	 * @param inputString
	 * @return
	 */
	private static byte[] hex2byte(String inputString) {
		if (inputString == null || inputString.length() < 2) {
			return new byte[0];
		}
		inputString = inputString.toLowerCase();
		int l = inputString.length() / 2;
		byte[] result = new byte[l];
		for (int i = 0; i < l; ++i) {
			String tmp = inputString.substring(2 * i, 2 * i + 2);
			result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
		}
		return result;
	}

	public static void main(String[] args) {
		try {

			// 生成AES密钥
			String key = generateKeyString();// "4d4cd0e76aecc5eca4dc322eaad3448b";
			System.out.println(key);
			// String key = "1234567890123456";

			// 内容
			String content = "峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我峰吴青峰委屈委屈委屈峰吴青峰我";

			// 用AES加密内容
			String miContent = AES.encrypt(content, key);
			System.out.println(miContent.length() + "  " + miContent);
			// 用AES解密内容
			String mingContent = AES.decrypt(miContent, key);
			System.out.println(mingContent.length() + "  " + mingContent);

		} catch (Exception e) {

		}

	}
}
