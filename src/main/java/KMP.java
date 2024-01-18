import java.util.ArrayList;
import java.util.List;

public class KMP {
    public List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        int[] lps = new int[m];
        int j = 0;

        computeLPSArray(pattern, m, lps);
        int i = 0;

        while (n - i >= m - j){
            if(pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                matches.add(i - j);
                j = lps[j - 1];
            }
            else if(i < n &&  pattern.charAt(j) != text.charAt(i)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i = i + 1;
                }
            }
        }

        return matches;

    }

    private void computeLPSArray(String pattern, int m, int[] lps) {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m){
            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            }else {
                if(length != 0 ){
                    length  = lps[length - 1];
                }else {
                    lps[i] = length;
                    i++;
                }
            }
        }
    }
}
