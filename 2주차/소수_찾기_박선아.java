import java.util.HashSet;
import java.util.Set;

/**
 * 문제 : 소수찾기 (Level 2)
 * 유형 : DFS (recursion 재귀), Set
 */
public class 소수_찾기_박선아 {

    public static Set<Integer> numSet;
    public static boolean[] isVisited;

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        numSet = new HashSet<>();
        isVisited = new boolean[numbers.length()];
        recursion("", 0, numbers);
        return numSet.size();
    }

    public static void recursion(String str, int index, String numbers) {
        if (index == numbers.length())
            return;
        if (str != "" && isPrime(Integer.parseInt(str)))
            numSet.add(Integer.parseInt(str));

        for (int i = 0; i < numbers.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                recursion(str + numbers.charAt(i), index++, numbers);
                isVisited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false; // 나누어질 경우
        }
        return true;
    }
}
