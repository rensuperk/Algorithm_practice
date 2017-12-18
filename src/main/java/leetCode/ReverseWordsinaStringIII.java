package leetCode; /**
 * Created by renkai on 2017/4/19.
 */
public class ReverseWordsinaStringIII {

    /**
     * 实现很复杂
     * @return
     */
    public static String soluation(char[] chars){
        String s = "absd";
        char[] chars1 = s.toCharArray();

        int i=0;
        int j = 0;
        int begin=0;
        int end=0;
        char temp;
        while ( i < chars.length){
            if(i >= end){
                //前一个空格的位置
                begin = end;
                //后一个空格的位置
                end = nextspace(begin,chars);
                j = 0;
            }
            //替换
            if(chars[i] !=' ' && j <  (end - begin) / 2){
                temp = chars[i];
                chars[i] = chars[end -1  -j];
                chars[end -1 -j ] = temp;
                j++;
            }
            i++;
        }
        return new String(chars);
    }

    /**
     * 查询下个空格的位置
     * @param current
     * @param chars
     * @return
     */
    public static int nextspace(int current,char[] chars){
        for (int i = current+1; i < chars.length; i++) {
            if(chars[i] == ' ') return i;
        }
        return chars.length;
    }

    public static char[] solution2(char[] s){
        // 从头到末尾翻转
//        reverse(s, 0, s.length);
        // 从头到尾遍历
        for (int i = 0, j = 0; j <= s.length; j++) {
            // 如果碰到空格（或者已经是末尾了），则翻转i到j位置的字符串，即一个单词。
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
        return s;
    }
    public static void reverse(char[] chars,int begin,int end){
        char temp ;
        for (int i = 0; i < (end - begin) / 2; i++) {
            temp = chars[begin + i];
            chars[begin + i] = chars[end -1 -i];
            chars[end -1 -i] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(soluation("abc cba ddd".toCharArray()));

        System.out.println(solution2("abc cba ddd".toCharArray()));
    }
}
