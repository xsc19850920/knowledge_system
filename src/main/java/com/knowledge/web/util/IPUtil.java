package com.knowledge.web.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by woodle on 15/1/19.
 */
public class IPUtil {

	private static Pattern ipPattern = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b");

	/**
	 * 获取客户端ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddressByRequest(HttpServletRequest request) {
//		String ip = request.getHeader("x-forwarded-for");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		} else {
//			String[] ips = ip.split(",");
//			for (int i = 0; i < ips.length; i++) {
//				ip = ips[i];
//				if (!(ip.startsWith("10.") || ip.startsWith("192.168") || ip.startsWith("172.16.") || ip.startsWith("19.2.168") || ip.equalsIgnoreCase("unknown"))) {
//					return ip.trim();
//				} else {
//					ip = null;
//				}
//			}
//		}
//
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		} else {
//			return ip.trim();
//		}
//
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}

		return "";
	}

	/**
	 * 将ip转化为int
	 * 
	 * @param ip
	 * @return
	 */
	public static long convertIpToInt(String ip) {
		String[] ipArray = StringUtils.split(ip, '.');
		long ipInt = 0;

		try {
			for (int i = 0; i < ipArray.length; i++) {
				if (ipArray[i] == null || ipArray[i].trim().equals("")) {
					ipArray[i] = "0";
				}
				if (new Integer(ipArray[i].toString()).intValue() < 0) {
					Double j = new Double(Math.abs(new Integer(ipArray[i].toString()).intValue()));
					ipArray[i] = j.toString();
				}
				if (new Integer(ipArray[i].toString()).intValue() > 255) {
					ipArray[i] = "255";
				}
			}
			ipInt = new Double(ipArray[0]).longValue() * 256 * 256 * 256 + new Double(ipArray[1]).longValue() * 256 * 256 + new Double(ipArray[2]).longValue() * 256 + new Double(ipArray[3]).longValue();
		} catch (Exception e) {
			// do nothing
		}
		return ipInt;
	}

	/**
	 * 将字符串型ip转成int型ip
	 * 
	 * @param strIp
	 * @return
	 */
	public static int Ip2Int(String strIp) {
		String[] ss = strIp.split("\\.");
		if (ss.length != 4) {
			return 0;
		}
		byte[] bytes = new byte[ss.length];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(ss[i]);
		}
		return byte2Int(bytes);
	}

	/**
	 * 将int型ip转成String型ip
	 * 
	 * @param intIp
	 * @return
	 */
	public static String int2Ip(int intIp) {
		byte[] bytes = int2byte(intIp);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(bytes[i] & 0xFF);
			if (i < 3) {
				sb.append(".");
			}
		}
		return sb.toString();
	}

	private static byte[] int2byte(int i) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (0xff & i);
		bytes[1] = (byte) ((0xff00 & i) >> 8);
		bytes[2] = (byte) ((0xff0000 & i) >> 16);
		bytes[3] = (byte) ((0xff000000 & i) >> 24);
		return bytes;
	}

	private static int byte2Int(byte[] bytes) {
		int n = bytes[0] & 0xFF;
		n |= ((bytes[1] << 8) & 0xFF00);
		n |= ((bytes[2] << 16) & 0xFF0000);
		n |= ((bytes[3] << 24) & 0xFF000000);
		return n;
	}

	/**
	 * 获取本地ip
	 * 
	 * @return
	 */
	public static String getLocalIP() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// do not nothing
		}
		return null;
	}

	/**
	 * 是否是一个ip
	 * 
	 * @param address
	 * @return
	 */
	public static boolean isIP(String address) {
		return ipPattern.matcher(address).matches();
	}

//	public static void main(String[] args) {
//		String ip1 = "192.168.1.1";
//		int intIp = Ip2Int(ip1);
//		String ip2 = int2Ip(intIp);
//		System.out.println(ip2.equals(ip1));
//	}
}
