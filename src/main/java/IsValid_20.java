/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * @author rensu
 * @date 2021/9/16 11:46
 **/
public class IsValid_20 {
    public static void main(String[] args) {
        IsValid_20 isValid_20 = new IsValid_20();
        System.out.println(isValid_20.isValid("(("));

    }
    public boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }
        Map<Character,Character> keyMap = new HashMap<>();
        keyMap.put(')','(');
        keyMap.put(']','[');
        keyMap.put('}','{');

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char  c =s.charAt(i);
            if (keyMap.containsKey(c)) {
                if (Objects.equals(stack.peek(),keyMap.get(c))){
                    stack.poll();
                }else{
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
       return stack.isEmpty();
    }
}
