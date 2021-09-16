/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */

/**
 * @author rensu
 * @date 2021/9/10 14:11
 **/
public class StringTest {
    public static void main(String[] args) {
        String a =new String("abc");
        String c ="abc";
        String b = a.intern();
        System.out.println(b==c);
    }
}
