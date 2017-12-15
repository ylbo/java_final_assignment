package Logic;

import Windows.TranslateWindows;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Translate {
    private TranslateWindows translateWindows;

    public Translate(TranslateWindows translateWindows) {
        this.translateWindows = translateWindows;
        this.translateWindows.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONObject jo = new JSONObject(sendStringToYoudao(translateWindows.getSearchArea().getText()));
                translateWindows.getMeaningArea().setText(jo.getJSONArray("translation").getString(0));
            }
        });
    }

    public static String sendStringToYoudao(String string) {
        String appKey = "7d0987ec4a1738bf";
        String query = string;
        //�ڿ����Ĺ����У������������������ǰ��̨����
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "zh-CHS";
        String to = "EN";
        String sign = md5(appKey + query + salt + "uMXFGtRKCJ7IKhOuBrPYH6rBzmHKNRW3");
        Map params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);
        String str = null;
        try {
            str = requestForHttp("http://openapi.youdao.com/api", params);
        } catch (Exception ss) {
            ss.printStackTrace();
        }
        return str;
    }

    public static String requestForHttp(String url, Map<String, String> requestParams) throws Exception {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**HttpPost*/
        HttpPost httpPost = new HttpPost(url);
        //System.out.println(new JSONObject(requestParams).toString());
        List params = new ArrayList();
        Iterator<Map.Entry<String, String>> it = requestParams.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> en = it.next();
            String key = en.getKey();
            String value = en.getValue();
            if (value != null) {
                params.add(new BasicNameValuePair(key, value));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        /**HttpResponse*/
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            EntityUtils.consume(httpEntity);
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ����32λMD5ժҪ
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = string.getBytes("utf-8");
            /** ���MD5ժҪ�㷨�� MessageDigest ���� */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** ʹ��ָ�����ֽڸ���ժҪ */
            mdInst.update(btInput);
            /** ������� */
            byte[] md = mdInst.digest();
            /** ������ת����ʮ�����Ƶ��ַ�����ʽ */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }
}
