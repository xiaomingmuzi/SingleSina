package com.lixm.singlesina.utils;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;


public class NetWorkHelper  {
	private Application context;
	private WifiManager wifiManger;
	private WifiInfo wifiInfo;

	public NetWorkHelper(Application application) {
		context = application;
	}

	public boolean isWifiActive() {
		wifiManger = (WifiManager) context.getSystemService(Service.WIFI_SERVICE);
		wifiInfo = wifiManger.getConnectionInfo();// 得到连接信息
		int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
		if (wifiManger.isWifiEnabled() && ipAddress != 0) {
			return true;
		} else {
			return false;
		}
	}

	// 获取连接类型//case 0:"mobile";  1:wifi
	public static int getConnectedType(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
				return mNetworkInfo.getType();
			}
		}
		return -1;
	}

	// 是否有网络，包括2g,3g.wifi
	public static boolean isNetActive() {
		boolean flag = false;
		ConnectivityManager manager = (ConnectivityManager) UIUtils.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		if (manager != null) {
			NetworkInfo netWorkInfo = manager.getActiveNetworkInfo();
			if (netWorkInfo != null) {
				flag = netWorkInfo.isAvailable();
			}
		}
		return flag;
	}


	/**
	 * // 当前应用的版本名称
	 * @return versionName
	 */
	public static String getVersionName() {
		try {
			PackageInfo info = UIUtils.getContext().getPackageManager().getPackageInfo(UIUtils.getContext().getPackageName(), 0);
			// 当前版本的版本号
			// int versionCode = info.versionCode;

			// 当前版本的包名
			// String packageNames = info.packageName;
			return info.versionName;
		} catch (Exception e) {
			LogUtil.i("<---错误--->" + e.getMessage());
			return "";
		}
	}

	/**
	 * 获取外网IP地址，子线程中使用，you know
	 * @return ip
	 */
	public static String getNetIp() {
		try {
			URL infoUrl = new URL("http://pv.sohu.com/cityjson?ie=utf-8");
			URLConnection connection = infoUrl.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) connection;
			int responseCode = httpConnection.getResponseCode();
			String line ;
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream inStream = httpConnection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
				StringBuilder strber = new StringBuilder();
				while ((line = reader.readLine()) != null)
					strber.append(line + "\n");
				inStream.close();
				// 从反馈的结果中提取出IP地址
				int start = strber.indexOf("{");
				int end = strber.indexOf("}");
				String json = strber.substring(start, end + 1);
				if (json != null) {
					try {
						JSONObject jsonObject = new JSONObject(json);
						line = jsonObject.optString("cip");
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				return line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取内网IP
	 * @return ip
	 */
	public static String getHostIP() {

		String hostIp = null;
		try {
			Enumeration nis = NetworkInterface.getNetworkInterfaces();
			InetAddress ia ;
			while (nis.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) nis.nextElement();
				Enumeration<InetAddress> ias = ni.getInetAddresses();
				while (ias.hasMoreElements()) {
					ia = ias.nextElement();
					if (ia instanceof Inet6Address) {
						continue;// skip ipv6
					}
					String ip = ia.getHostAddress();
					if (!"127.0.0.1".equals(ip)) {
						hostIp = ia.getHostAddress();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hostIp;

	}
}
