package com.lixm.singlesina.network;

/**
 * @author Lixm
 * @date 2018/1/23
 * @detail
 */

public interface IOKCallBack {
    void onException(Exception e);
    void onSuccess(String result);
}
