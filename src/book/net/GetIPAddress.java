package book.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         GetIPAddress
 * 创建时间： 2018年1月22日上午9:03:34
 * 修改人：     Jefy
 * 类描述：    获取本机IP、主机名以及远程服务器IP地址
 */
public class GetIPAddress {
	/**
	 * 获取本机IP地址
	 * @return 本机IP地址
	 * @throws UnknownHostException
	 */
	public static String getLocalIP() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		return addr.getHostAddress();
	}
	/**
	 * 获取本机主机名
	 * @return 本机主机名
	 * @throws UnknownHostException
	 */
	public static String getLocalHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		return addr.getHostName();
	}
	/**
	 * 根据域名获得主机的IP地址
	 * @param hostName
	 * @return
	 * @throws UnknownHostException 
	 */
	public static String getIPByName(String hostName) throws UnknownHostException {
		InetAddress addr = InetAddress.getByName(hostName);
		return addr.getHostAddress();
	}
	/**
	 * 根据域名获得主机所有的IP地址
	 * @param hostName
	 * @return
	 * @throws UnknownHostException
	 */
	public static String[] getAllIPByName(String hostName) throws UnknownHostException {
		InetAddress[] addrs = InetAddress.getAllByName(hostName);
		String[] ips = new String[addrs.length];
		for (int i = 0; i < addrs.length; i++) {
			ips[i] = addrs[i].getHostAddress();
		}
		return ips;
	}
	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		//获取本机IP地址和机器名
		System.out.println("Local IP: " + GetIPAddress.getLocalIP());
		System.out.println("Local HostName: " + GetIPAddress.getLocalHostName());
		
		//根据域名获得主机IP
		System.out.println();
		String hostName = "www.baidu.com";
		System.out.println("域名为：" + hostName + "的主机的IP地址：");
		System.out.println(GetIPAddress.getIPByName(hostName));
		
		System.out.println();
		System.out.println("域名为" + hostName + "的主机的所有IP地址：");
		String[] ips = GetIPAddress.getAllIPByName(hostName);
		for (int i = 0; i < ips.length; i++) {
			System.out.println(ips[i]);
		}
	}
}
