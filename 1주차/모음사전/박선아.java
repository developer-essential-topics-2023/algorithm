public class 모음사전 {

    public static String[] vowel;
    public static int count; // 몇번째 인지 결과값
    public static boolean isWordMatch; // word match 확인

    public static void main(String[] args) {
        vowel = new String[]{"A", "E", "I", "O", "U"};
        System.out.println(solution("AAAAE"));
    }

    public static int solution(String word) {
        count = 0;
        isWordMatch = false;
        recursion(word, "", 0);
        return count;
    }

    public static void recursion(String word, String str, int depth) {
        if (str.equals(word)) {
            isWordMatch = true;
            return;
        }
        if (depth == 5) return;
        for (int i = 0; i < vowel.length; i++) {
            count++;
            recursion(word, str + vowel[i], depth + 1);
            if (isWordMatch) return;
        }
    }
}

/**
 class Solution {
     public int solution(String word) {
         String str = "AEIOU";
         int[] x = {781,156,31,6,1};
         // f(1) = 1 + 5 ^0
         // f(2) = 6 = f(1) + 5 ^1
         // f(3) = 31 = f(2) + 5 ^ 2
         // f(4) = 156 = f(3) + 5 ^3
         int index,result=word.length();

         for(int i=0; i<word.length(); i++){
             index = str.indexOf(word.charAt(i)); // 위치 열
             result+=x[i]*index;
         }
        return result;*
     }
 }
 **/