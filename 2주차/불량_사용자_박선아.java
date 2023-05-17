package 2주차;

import java.util.*;

/**
 * 유형 : Set / DFS
 */
public class 불량_사용자_박선아 {
    public static Set<Set<String>> nameList;

    public static void main(String[] args) {
        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = new String[]{"fr*d*", "abc1**"};

        nameList = new HashSet<>();

        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {

        dfs(new HashSet<>(), 0, user_id, banned_id);
        return nameList.size();
    }

    public static void dfs(Set<String> set, int index, String[] user_id, String[] banned_id) {
        if (index == banned_id.length) {
            nameList.add(set);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!set.contains(user_id[i]) && checkMatch(user_id[i], banned_id[index])) {
                set.add(user_id[i]);
                dfs(new HashSet<>(set), index+1, user_id, banned_id);
                set.remove(user_id[i]);
            }
        }
    }

    public static boolean checkMatch (String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        return true;
    }

}
