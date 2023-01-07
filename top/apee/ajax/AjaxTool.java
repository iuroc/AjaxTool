package top.apee.ajax;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Ajax 请求工具类
 * 
 * <pre>
 * 用法介绍：
 * 
 * // 导入类
 * import top.apee.ajax.AjaxTool;
 * 
 * // 请求地址
 * String url = "https://www.apee.top";
 * 
 * // 简单发送请求
 * ajax(url)
 * 
 * // 带回调函数
 * IAjaxCallback iCallback = (String result) -> {
 *     System.out.println(result);
 * };
 * ajax(url, iCallback);
 * 
 * // 多个参数
 * String method = "POST";
 * String content = "a=1&b=2&c=3";
 * String[][] headers = {{"Content-Type", "application/json"}};
 * ajax(url, method, content, headers);
 * 
 * // 多个参数，带回调函数
 * ajax(url, method, content, headers, iCallback);
 * </pre>
 * 
 * @author 欧阳鹏
 * @version 2023-01-05
 */
public class AjaxTool {

    /**
     * 发送 HTTP 请求
     * 
     * @param url       请求地址
     * @param method    请求方式
     * @param content   请求参数
     * @param headers   请求标头
     * @param iCallback 回调函数
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url, String method, String content, String[][] headers, IAjaxCallback iCallback)
            throws Exception {
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
        conn.setRequestMethod(method);
        for (String[] header : headers) {
            conn.setRequestProperty(header[0], header[1]);
        }
        conn.setDoOutput(true);
        DataOutputStream output = new DataOutputStream(conn.getOutputStream());
        output.writeBytes(content);
        output.flush();
        output.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuffer result = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        if (iCallback != null) {
            iCallback.call(result.toString());
        }
        return conn.getResponseCode();
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url 请求地址
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url) throws Exception {
        return ajax(url, "GET", "", new String[0][0]);
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url 请求地址
     * @return 响应状态码
     * @param iCallback 回调函数
     * @throws Exception
     */
    public static int ajax(String url, IAjaxCallback iCallback) throws Exception {
        return ajax(url, "GET", "", new String[0][0], iCallback);
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url    请求地址
     * @param method 请求方式
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url, String method) throws Exception {
        return ajax(url, method, "", new String[0][0]);
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url       请求地址
     * @param method    请求方式
     * @param iCallback 回调函数
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url, String method, IAjaxCallback iCallback) throws Exception {
        return ajax(url, method, "", new String[0][0], iCallback);
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url     请求地址
     * @param method  请求方式
     * @param content 请求参数
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url, String method, String content) throws Exception {
        return ajax(url, method, content, new String[0][0]);
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url       请求地址
     * @param method    请求方式
     * @param content   请求参数
     * @param iCallback 回调函数
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url, String method, String content, IAjaxCallback iCallback) throws Exception {
        return ajax(url, method, content, new String[0][0], iCallback);
    }

    /**
     * 发送 HTTP 请求
     * 
     * @param url     请求地址
     * @param method  请求方式
     * @param content 请求参数
     * @return 响应状态码
     * @throws Exception
     */
    public static int ajax(String url, String method, String content, String[][] header) throws Exception {
        return ajax(url, method, content, new String[0][0], null);
    }
}