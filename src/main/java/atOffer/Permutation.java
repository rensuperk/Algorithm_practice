package atOffer;

import groovy.json.JsonOutput;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        ArrayList<String> strings = permutation.Permutation("aab");
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(JsonOutput.toJson(strings.get(i)));
        }
    }


    /**
     * 解析，书上的思路是
     * 把第一个字符和后面的字符依次交换
     * 把后面字符分成两个部分然后逐一和后面的字符交换。
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strings = new ArrayList<>();
        if (str  == null || str.equals("") ){
            return strings;
        }
        String temp = str;
        char[] chars = str.toCharArray();
        //全排列！

        PermutationHelp(chars,0,strings);
        Collections.sort(strings);
         return strings;
    }
    public void PermutationHelp(char[] str,int begin,ArrayList<String> strings) {
        if(begin == (str.length-1)){
            String s = String.valueOf(str);
            if(!strings.contains(s)){
                strings.add(s);
            }
        }else {
            for (int i = begin; i < (str.length); i++) {
                if(i == begin || str[i] != str[begin]){
                    swap(str,i,begin);
                    PermutationHelp(str,begin+1,strings);
                    swap(str,i,begin);
                }
            }
        }
    }
    private void swap(char[] cs,int i,int j){
        if(cs != null && i<cs.length && j < cs.length){
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }
}
