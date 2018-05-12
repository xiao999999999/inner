package com.hbt.inner.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 描述：工具
 * @author Json
 * @date 2018-05-12
 */
public class CommonUtils {

    //文件路径
    public static String IMAGE_PATH="E:/upload/";
    //判断上传文件是否为图片
    public static String[] IMAGE_TYPE={"jpg","gif","jpeg","png","bmp"};
    public static boolean isPic(String fileExt){
        for(int i=0;i<IMAGE_TYPE.length;i++){
            if(fileExt.equals(IMAGE_TYPE[i])){
                return true;
            }
        }
        return false;
    }
    public static String getJSONString(String code) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        return json.toJSONString();
    }

    public static String getJSONString(String  code, String msg) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        return json.toJSONString();
    }

    public static String getJSONString(int code, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json.toJSONString();
    }

    /*--------------------List转字符串---------------------*/
    public static String listToString(List<String> list, String separator, String open,
                                      String close) {
        if (list == null || list.size() < 1)
            return "";
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        for (String str : list) {
            sb.append(open).append(str).append(close);
            if (index + 1 < list.size())
                sb.append(separator);
            index++;
        }
        return sb.toString();
    }

    public static String listToString(List<String> list) {
        return listToString(list, ",", "", "");
    }

    public static String listToSqlString(List<String> list) {
        return listToString(list, ",", "'", "'");
    }


    /*---------------------非空判断-----------------------*/
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static <T> List<T> arrayListNullToEmpty(List<T> collection) {
        return isEmpty(collection) ? new ArrayList<T>() : collection;
    }

    public static boolean isAnyEmpty(String... strs) {
        for (String str : strs) {
            if (str == null || "".equals(str))
                return true;
        }
        return false;
    }

    /*---------------------方法内部性能调试----------------*/
    public static void methodCost(Long start, String methodName, StringBuilder sb) {
        Long tEnd = System.currentTimeMillis();
        sb.append(methodName + " execute cost time " + (tEnd - start) + " ms\n");
        start = tEnd;
    }

    public static void methodCost(Long start, String methodName) {
        Long tEnd = System.currentTimeMillis();
        System.out.println(methodName + " execute cost time " + (tEnd - start) + " ms\n");
        start = tEnd;
    }


    /**
     * json 转对象
     *
     * @return 对象数组
     */
    public static <T> List<T> parseObjects(String json, Class<T> clazz) {
        if (isEmpty(json)) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<T>();
        if (json.charAt(0) == '[') {
            list = JSONArray.parseArray(json, clazz);
        } else {
            T entity = JSON.parseObject(json, clazz);
            list.add(entity);
        }
        return list;
    }

    /**
     * 向 value 为List<V> 的map中添加值
     */
    public static <K, V> void addMapList(Map<K, List<V>> map, K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<V>());
        }
        map.get(key).add(value);
    }

    public static void main(String[] args) {
        List<String> metrics = new ArrayList<String>();
        metrics.add("02010100");
        metrics.add("02010200");
        metrics.add("02010300");
        metrics.add("02020100");
        System.out.println(listToString(metrics, "==", "<", ">"));
        System.out.println(listToString(metrics));
        System.out.println(listToSqlString(metrics));
    }

    public static <T> List<T> getListByJson(String json, Class<T> tClass) {

        List<T> list = new ArrayList<T>();
        if (json.charAt(0) == '[') {
            list = JSONArray.parseArray(json, tClass);
        } else {
            T rule = JSON.parseObject(json, tClass);
            list.add(rule);
        }

        return list;
    }

}


