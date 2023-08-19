package main.java1.immutable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jitendra.kumar01
 * 21/02/20
 */
public class
ImmutableLClassWithMap {
    private int var1;

    private final HashMap<String, String> testMap;


    public ImmutableLClassWithMap(int var, HashMap<String, String> testMap) {
        this.var1 = var;
        HashMap<String, String> tempMap1 = new HashMap<String, String>();
        String key;
        Iterator<String> it = testMap.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            tempMap1.put(key, testMap.get(key));
        }
        this.testMap = tempMap1;
    }

    public HashMap<String, String> getTestMap() {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;

        //return (HashMap<String, String>) testMap.clone();
    }

    public int getVar1() {
        return var1;
    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");
        int i = 10;
        // TODO Auto-generated method stub
        ImmutableLClassWithMap im = new ImmutableLClassWithMap(i, h1);

        //Lets see whether its copy by field or reference
        System.out.println(h1 == im.getTestMap());
        //print the ce values
        System.out.println("ce id:" + im.getVar1());
        System.out.println("ce testMap:" + im.getTestMap());

        //change the local variable values
        i = 20;

        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:" + im.getVar1());
        System.out.println("ce testMap after local variable change:" + im.getTestMap());
    }
}
