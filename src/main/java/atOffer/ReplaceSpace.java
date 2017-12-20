package atOffer;


/**
 * 题目描述
 * 请实现一个函数，
 * 将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 时间限制：1秒 空间限制：32768K
 *
 *
 *
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
