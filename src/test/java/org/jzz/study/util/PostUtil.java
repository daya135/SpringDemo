package org.jzz.study.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.test.util.http.ssl.TLSSocketConnectionFactory;

public class PostUtil {
	
	public static String callRMI(String rmiPath, Map<String, String> params) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(rmiPath);

			URLConnection conn = realUrl.openConnection();

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

			conn.setDoOutput(true);
			conn.setDoInput(true);

			if (conn instanceof HttpsURLConnection) {
				((HttpsURLConnection) conn).setHostnameVerifier(HttpsURLConnection.getDefaultHostnameVerifier());
				((HttpsURLConnection) conn).setSSLSocketFactory(new TLSSocketConnectionFactory());
			}

			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
			String paramStr = null;
			if (params != null && params.size() > 0) {
				StringBuilder paramsBuilder = new StringBuilder("");
				for (String key : params.keySet()) {
					paramsBuilder.append(key);
					paramsBuilder.append("=");
					paramsBuilder.append(params.get(key));
					paramsBuilder.append("&");
				}
				paramStr = paramsBuilder.deleteCharAt(paramsBuilder.length() - 1).toString();
			}

			out.print(paramStr);

			out.flush();

			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("xxxx" + e);
			e.printStackTrace();
		}

		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		String url = "http://localhost:8080/shutdown";
		Map<String, String> params = new HashMap<String, String>();
		PostUtil.callRMI(url, params);
	}
}
