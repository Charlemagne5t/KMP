import java.util.ArrayList;
import java.util.List;

public class KMP2 {
    void getPatternMatchingIndex(String text, String pattern, List<Integer> list) {
        String t = pattern + "@" + text;
        List<Integer> lps = new ArrayList<>();
        lps.add(0);
        for (int i = 1; i < t.length(); ++i) {
            int ind = lps.get(i - 1);
            while (ind > 0 && t.charAt(ind) != t.charAt(i)) {
                ind = lps.get(ind - 1);
            }
            lps.add((t.charAt(ind) == t.charAt(i)) ? ind + 1 : 0);
        }
        for (int i = 0; i < lps.size(); ++i) {
            if (lps.get(i) == pattern.length()) {
                list.add(i - 2 * pattern.length());
            }
        }
    }
}
