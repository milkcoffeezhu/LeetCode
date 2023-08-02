package com.luck.leetcode6;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhuxs2
 * @date 2023/7/9 20:12:25
 */
public class Solution {
    /**
     * 按照规则可以执行如下操作
     * 1 创建一个[1001][1001]的二维数组
     * 2 遍历规则
     *   使用i表示行坐标,使用j表示列坐标
     *   if i == 0 向下遍历直到 i == num -1
     *   if i == numRows -1 斜着向上遍历坐标变化num[i-1][j+1] 直到 i - 1 = 1 这个是一个完整的周期
     *   重复上述逻辑直到字符串被遍历完
     * 3 遍历二维数组取值返回
     *
     * 时间复杂度: num*length + length 极端情况还是n*n
     * 空间复杂度 n*n
     *
     */
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (length == 1){
            return s;
        }

        if (numRows == 1){
            return s;
        }

        int i = 0;

        boolean startUp = false;
        boolean startDown = false;

        Map<Integer,StringBuilder> map = new TreeMap<>();

        for (int k = 0; k < length; k++) {
            //从上到小
            if (i == 0){
                if (startDown){
                    i++;
                }
                startUp = true;
            }
            if (i < numRows && startUp){
                if (map.containsKey(i)){
                    StringBuilder builder = map.get(i);
                    builder.append(s.charAt(k));
                    map.put(i,builder);
                }else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(k));
                    map.put(i,sb);
                }
                i++;
            }else {
                //斜着向上走
                if (i == numRows){
                    startUp = false;
                    startDown = true;
                    i--;
                }
                if (i != 0 && !startUp){
                    i = i -1;
                    if (map.containsKey(i)){
                        StringBuilder builder = map.get(i);
                        builder.append(s.charAt(k));
                        map.put(i,builder);
                    }else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.charAt(k));
                        map.put(i,sb);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, StringBuilder> entry : map.entrySet()) {
            result.append(entry.getValue());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String test = "AB";
        System.out.println(convert(test,1));
    }
}
