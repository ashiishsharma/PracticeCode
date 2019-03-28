package com.ashish;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

import java.util.*;

public class GroupAnagrams {


    void sort(String[] array) {
        ListMultimap<Object, Object> mapList = MultimapBuilder.hashKeys().arrayListValues().build();
        /* Group words by anagram */
        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }
        /*Convert hash table to array*/
        int index = 0;
        for (Object key : mapList.keySet()) {
            List<Object> list = mapList.get(key);
            for (Object t : list) {
                array[index] = (String) t;
                index++;
            }
        }
    }

    String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

 /*HashMapList<String, Integer> is a HashMap that maps from Strings to
  Arraylist<Integer>. See appendix for implementation. */

    public void sortAnagrams(String[] array) {
        Arrays.sort(array, new AnagramComparator());
    }

    class AnagramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String sl, String s2) {
            return sortChars(sl).compareTo(sortChars(s2));
        }
    }
}
