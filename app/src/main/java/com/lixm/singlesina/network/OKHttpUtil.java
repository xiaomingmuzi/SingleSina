package com.lixm.singlesina.network;


import android.os.Handler;

import com.lixm.singlesina.utils.LogUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Lixm
 * @date 2018/1/23
 * @detail  OKHttp 工具类
 */

public class OKHttpUtil {
    private static String TAG="OKHttpUtil";
    //保证OKHttpClient是唯一的
    private static OkHttpClient okHttpClient;
    static Handler mHandler=new Handler();

    static {
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient();
        }
    }

    public static void httpGet(RequestParams params, final IOKCallBack callBack){
        if (callBack==null) throw new NullPointerException("callBack is null");
        final Request request=new Request.Builder().url(params.getParams()).build();
        LogUtil.i("Get load："+params.getParams());
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                e.printStackTrace();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onException(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                LogUtil.i("Get success："+PrintJsonLog.iJsonFormat(result,false));
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }

    public static void httpPost(RequestParams params,final IOKCallBack callBack){
        if (callBack==null) throw new NullPointerException("callback is null");
        if (params==null) throw new NullPointerException("params is null");
        FormBody.Builder formBodyBuilder=new FormBody.Builder();
        StringBuffer stringBuffer=new StringBuffer(params.getUri());
        stringBuffer.append("\n");
        stringBuffer.append("Param：");
        List<KeyValue> KeyValues=params.getBodyParams();
        for (KeyValue keyValue:KeyValues){
            formBodyBuilder.add(keyValue.key,keyValue.getValueStr());
            stringBuffer.append("&"+keyValue.key+"="+keyValue.getValueStr());
        }
        LogUtil.i("Post load："+stringBuffer.toString());
        FormBody formBody=formBodyBuilder.build();
        Request request=new Request.Builder().post(formBody).url(params.getUri()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                e.printStackTrace();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onException(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                LogUtil.i("Post success："+PrintJsonLog.iJsonFormat(result,false));
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });

    }



}
