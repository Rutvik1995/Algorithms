package com.blogspot.vikkyrk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Find the 'K' frequent words in 
 */
public class WordFrequencyCount {
    HashMap<String, Integer> hM = new HashMap<String, Integer>();
    
    String fileName = "/home/vikasrk/Desktop/temp.txt";
    
    File file = new File(fileName);
    
    Comparator<Map.Entry<String, Integer>> cP = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> o1,
                Entry<String, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
        
    };
    
    public void getTopKFrequentWords() throws Exception {
        
        BufferedReader bR = new BufferedReader(new FileReader(file));
        String s;
        while((s = bR.readLine()) != null) {
            String[] sA = s.split("\\s+");
            updateMap(sA);
        }
        bR.close();
        
        Set<Map.Entry<String, Integer>> hS = hM.entrySet();
        
        PriorityQueue<Map.Entry<String, Integer>> pQ = 
                new PriorityQueue<Map.Entry<String, Integer>>(hS.size(), cP);
        pQ.addAll(hS);
        
        for(int i=0; i<10; i++) {
            System.out.println(pQ.remove());
        }
        
    }
    
    private void updateMap(String[] sA) {
        for(String s: sA) {
            if(hM.containsKey(s)) {
                hM.put(s, hM.get(s)+1);
            } else
                hM.put(s,1);
        }
    }
}
