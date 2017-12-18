package leetCode;
import java.util.ArrayList;
import java.util.List;

/**判断是否在一行
 * Created by renkai on 2017/4/19.
 */
public class KeyboardRow {
    public String[] solution(String[] input){
        List<String> list = new ArrayList<String>();
        String u ="qwertyuiop";
        String m ="asdfghjkl";
        String d ="zxcvbnm";
        for (int i = 0; i < input.length; i++) {
            int before = 0;
            int next = 0;
            boolean bflag = true;
            char[] chars = input[i].toLowerCase().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if(contain(u,chars[j])){
                    next =0;
                }else if(contain(m,chars[j])){
                    next =1;
                }else if(contain(d,chars[j])){
                    next =2;
                }
                if(j > 0 && before != next){
                    bflag = false;
                    break;
                }
                before = next;
            }
            if(bflag){
                list.add(input[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
    boolean contain(String s,char c){
        for (char c1 : s.toCharArray()) {
            if(c1 == c){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();
        String[] solution = keyboardRow.solution(new String[]{"asd", "qwe"});
        for (String s : solution) {

            System.out.println(s);
        }
    }
}
