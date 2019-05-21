package exercise.exercise_0521;


/*

[编程题]统计回文
热度指数：24759时间限制：1秒空间限制：32768K
 算法知识视频讲解
“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。
现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。你接受花花的请求，
帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
例如：
A = “aba”，B = “b”。这里有4种把B插入A的办法：
* 在A的第一个字母之前: "baba" 不是回文
* 在第一个字母‘a’之后: "abba" 是回文
* 在字母‘b’之后: "abba" 是回文
* 在第二个字母'a'之后 "abab" 不是回文
所以满足条件的答案为2

 */
/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int count = judge(A+B) ? 1 : 0;
        for(int i=0,len=A.length(); i<len; i++){
            if(judge(A.substring(0,i)+B+A.substring(i))){
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean judge(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
}
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 3;
        while(sc.hasNext()){
            int em_bottle = sc.nextInt();
            System.out.println(solution(em_bottle,c));
        }
    }
    private static int solution(int em_bottle,int c){
        int count = 0;
        while(em_bottle >= c){
            count += em_bottle/c;//喝掉汽水数累加
            em_bottle = em_bottle%c + em_bottle/c; //更新空瓶子
        }
        return em_bottle == c-1 ? count+1 : count;
    }
}
