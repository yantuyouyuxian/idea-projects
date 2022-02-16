package leetcode2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode395 {

    public static void main(String[] args) {
        function_1("weitong",1);
        System.out.println("res="+res);
    }
    static int res=0;
    public static int longestSubstring(String s, int k) {
        res=0;
        function_1(s,k);
        return res;
    }
    public static void function_1(String s,int k){
        System.out.println("string="+s);
        //作为统计字母个数的数组
        int [] chars=new int[26];
        for (int i=0;i<chars.length;i++){
            chars[i]=0;
        }
        //首先字符串的长度要大于等于k
        if(s.length()<k){
            return;
        }
        //遍历统计字符串中字母a-z的个数
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }

        System.out.println("统计结果：");
        //找到统计结果中，总数大于0，但小于k的字母
        Set<Integer> charsSet=new HashSet<>();//记录有那些字母个数是小于k的
        for(int i=0;i<chars.length;i++){
            if(chars[i]>0){
                System.out.println((char)('a'+i)+":"+chars[i]);
            }
            if(chars[i]>0 && chars[i]<k){
                System.out.println("个数小于k的字母:");
                System.out.println((char)('a'+i)+":"+chars[i]);
                charsSet.add(('a'+i));
            }
        }
        if(charsSet.size()==0){
            res=(s.length()>res? s.length():res);
            return;
        }
        //记录不需要的字母在字符串中的坐标
        List<Integer> indexList=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(charsSet.contains(Integer.valueOf(s.charAt(i)))){
                indexList.add(i);
            }
        }
        System.out.println("坐标位置：");
        for (Integer integer : indexList) {
            System.out.println(integer);
        }
        for(int i=0;i<indexList.size();i++){
            if(i==indexList.size()-1 && indexList.get(i)<s.length()-1){
                function_1(s.substring(indexList.get(i)+1),k);
            }
            if(i==0){
                if(indexList.get(i)-0>=k){
                    function_1(s.substring(0,indexList.get(i)),k);
                }
            }else{
                if((indexList.get(i)-indexList.get(i-1)-1)>=k){
                    function_1(s.substring(indexList.get(i-1)+1,indexList.get(i)),k);
                }
            }
        }
    }
}
