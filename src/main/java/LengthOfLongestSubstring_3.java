/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author rensu
 * @date 2021/9/8 18:44
 **/
class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring_3();
        int i = lengthOfLongestSubstring3.lengthOfLongestSubstring("dvdf");
        System.out.println(i);
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int subLength = 0;
            Set<Character> subStrings = new HashSet<>();
            for (int j = i; j <s.length(); j++) {
                char subString =s.charAt(j);
                if (subStrings.contains(subString)){
                    break;
                }
                subStrings.add(subString);
                subLength++;
            }
            max = Math.max(subLength,max);
        }
        return max;
    }
}
