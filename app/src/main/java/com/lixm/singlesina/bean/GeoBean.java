package com.lixm.singlesina.bean;

/**
 * @author Lixm
 * @date 2018/1/24
 * @detail 地理信息
 */

public class GeoBean {
    private String longitude;//经度坐标
    private String latitude;//维度坐标
    private String city;//所在城市的城市代码
    private String province;//所在省份的省份代码
    private String city_name;//所在城市的城市名称
    private String province_name;//	所在省份的省份名称
    private String address;//所在的实际地址，可以为空
    private String pinyin;//	地址的汉语拼音，不是所有情况都会返回该字段
    private String more;//	更多信息，不是所有情况都会返回该字段
}
