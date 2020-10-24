package Thread;

import java.util.*;

public class test3 extends Thread{

    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */
    public static Set<String> showMap(Map<String, Object> map) {
        //TODO your code goes here...
        Set<String> res = new HashSet<>();
        for (String str : map.keySet()){
            StringBuilder tmp = new StringBuilder();
            // 当 value 是 String
            if (map.get(str) instanceof String || map.get(str) == null){
                tmp.append(str + " = " + map.get(str));
                res.add(tmp.toString());
            }
            // 当 value 是 Number
            else if (map.get(str) instanceof Number){
                tmp.append(str + " = " + map.get(str));
                res.add(tmp.toString());
            }
            // 当 value 是 Object[]
            else if (map.get(str) instanceof Object[]){
                Object[] obj = (Object[]) map.get(str);
                for (int i = 0; i < obj.length; i++){
                    if (obj[i] instanceof String || obj[i] == null){
                        tmp.append(str + "[" + i + "] = " + (String)obj[i]);
                        res.add(tmp.toString());
                        tmp = new StringBuilder();
                    }
                    else if (obj[i] instanceof Number){
                        tmp.append(str + "[" + i + "] = " + (Number)obj[i]);
                        res.add(tmp.toString());
                        tmp = new StringBuilder();
                    }
                    else if (obj[i] instanceof Object[]){
                        Map<String, Object> map1 = new HashMap<>();
                        map1.put("", obj[i]);
                        Set<String> set1 = new TreeSet<>(showMap(map1));
                        for (String s1 : set1){
                            tmp.append(str + "[" + i + "]." + s1);
                            res.add(tmp.toString());
                            tmp = new StringBuilder();
                        }
                    }
                    else if (obj[i] instanceof Map){
                        Set<String> set3 = showMap((Map<String, Object>) obj[i]);
                        for (String s3 : set3){
                            tmp.append(str + "[" + i + "]." + s3);
                            res.add(tmp.toString());
                            tmp = new StringBuilder();
                        }
                    }
                }
            }
            else if (map.get(str) instanceof Map){
                Set<String> set2 = showMap((Map<String, Object>) map.get(str));
                for (String s1 : set2){
                    tmp.append(str + "." + s1);
                    res.add(tmp.toString());
                    tmp = new StringBuilder();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map.put("c", 0);
        Object[] obj = {"v", 2, map};
        map1.put("b", obj);

        Object[] obj1 = {1, null, 3};
        map2.put("d", obj1);
        map2.put("a", map1);
        map2.put("g", null);
        map2.put("f", null);
        Set<String> set = showMap(map2);
        for (String s : set){
            System.out.println(s);
        }
    }
}
