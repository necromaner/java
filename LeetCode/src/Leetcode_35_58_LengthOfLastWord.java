/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 下午3:23
 */
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5


 */
public class Leetcode_35_58_LengthOfLastWord {//完成
    public static void main(String[] args) {
        Solution35 solution35=new Solution35();
        String word="a ";
        System.out.println("input :"+word);
        System.out.println("output :"+solution35.lengthOfLastWord(word));
        
    }
}
class Solution35 {
    public int lengthOfLastWord(String s) {
        int num=0;
        char[] sList=s.toCharArray();
        for (int i = sList.length-1; i >=0 ; i--) {
            if (sList[i]>='a'&&sList[i]<='z'||sList[i]>='A'&&sList[i]<='Z'){
                num++;
            }else if(sList[i]==' '&&num!=0)
                break;
        }
        return num;
    }
}
