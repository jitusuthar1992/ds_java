package main.java1.multithreading.concurrent.utils;

import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
public class ConcurrentHashMapStructure {
    public static void main(String[] args) {

        State india=new State("Raj", 1000);
        State japan=new State("Guj",10000);

        State france=new State("UP",2000);
        State russia=new State("MH",20000);

        ConcurrentHashMap<State,String> stateStringConcurrentHashMap=new ConcurrentHashMap<State,String>();
        stateStringConcurrentHashMap.put(india,"Delhi");
        stateStringConcurrentHashMap.put(japan,"Tokyo");
        stateStringConcurrentHashMap.put(france,"Paris");
        stateStringConcurrentHashMap.put(russia,"Moscow");

        Iterator countryCapitalIter=stateStringConcurrentHashMap.keySet().iterator();//put debug point at this line
        while(countryCapitalIter.hasNext())
        {
            State countryObj= (State) countryCapitalIter.next();
            String capital=stateStringConcurrentHashMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
        }
    }

}
