package com.camera.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nullzZ
 *
 */
public class AnySdkPayNotify {
	/**
	 * AnySDK 分配的 PrivateKey
	 *
	 * 正式使用的时候记得使用AnySDK分配的正式的 PrivateKey
	 */
	private static String privateKey = "";

	/**
	 * 全局数组,用于base64
	 */
	private final String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
			"f" };

	public AnySdkPayNotify() {
	}

	/**
	 * 验证签名
	 *
	 * @param paramValues 待签字符串
	 * @param originSign 从AnySDK接收到的sign值
	 * @return boolean
	 */
	public boolean checkSign(String paramValues, String originSign) {
		if (originSign == null) {
			return false;
		}
		String newSign = getSign(paramValues);
		return newSign.equals(originSign);
	}

	/**
	 * 设置 private_key
	 */
	public void setPrivateKey(String privateKey) {
		AnySdkPayNotify.privateKey = privateKey;
	}

	/**
	 * 计算待签字符串的sign值
	 *
	 * @param paramValues 待签字符串
	 * @return String 计算所得到的sign签名
	 */
	public String getSign(String paramValues) {
		String md5Values = MD5Encode(paramValues);
		md5Values = MD5Encode(md5Values.toLowerCase() + privateKey).toLowerCase();
		return md5Values;
	}

	/**
	 * MD5编码算法
	 *
	 * @param sourceStr 待计算的字符串
	 * @return String md5值
	 */
	public String MD5Encode(String sourceStr) {
		String signStr = null;
		try {
			byte[] bytes = sourceStr.getBytes("utf-8");
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(bytes);
			byte[] md5Byte = md5.digest();
			if (md5Byte != null) {
				signStr = byteToString(md5Byte);
			}
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return signStr;
	}

	/**
	 * 返回形式为数字跟字符串
	 */
	private String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	/**
	 * 转换字节数组为16进制字串
	 */
	private String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}
}
