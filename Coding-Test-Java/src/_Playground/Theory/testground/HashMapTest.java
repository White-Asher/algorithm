package _Playground.Theory.testground;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("안녕", 1);
        map.put("하세요", 2);

        System.out.println(map.get("안녕"));

        for (String key : map.keySet()) {
            System.out.println("key : " + key + "  value: "+ map.get(key));
        }

    }
}
