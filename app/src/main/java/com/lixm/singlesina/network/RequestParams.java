package com.lixm.singlesina.network;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lixm
 * @date 2018/1/23
 * @detail
 */

public class RequestParams {
    private List<KeyValue> bodyParams = new ArrayList<KeyValue>();
    private String uri;

    /**
     * @param uri 不可为空
     */
    public RequestParams(String uri) {
        this.uri = uri;
    }

    /**
     * 添加参数至Body
     *
     * @param name
     * @param value
     */
    public void addBodyParameter(String name, String value) {
        this.bodyParams.add(new KeyValue(name, value));
    }

    public String getParams() {
        StringBuffer stringBuffer = new StringBuffer(uri);
        for (int i = 0; i < bodyParams.size(); i++) {
            KeyValue keyValue = bodyParams.get(i);
            if (i == 0)
                stringBuffer.append("?");
            else
                stringBuffer.append("&");
            stringBuffer.append(keyValue.key + "=" + keyValue.getValueStr());
        }
        return stringBuffer.toString();
    }

    public String getUri() {
        return this.uri;
    }

    public List<KeyValue> getBodyParams() {
        return bodyParams;
    }

}
