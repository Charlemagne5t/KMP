import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KMPTest {
    @Test
    public void test1(){
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        List<Integer> epxected = new ArrayList<>(List.of(10));
        List<Integer> actual = new KMP().KMPSearch(text, pattern);

        Assert.assertEquals(epxected, actual);

    }
    @Test
    public void test2(){
        String text = "sadbutsad";
        String pattern = "sad";
        List<Integer> epxected = new ArrayList<>(List.of(0, 6));
        List<Integer> actual = new KMP().KMPSearch(text, pattern);

        Assert.assertEquals(epxected, actual);

    }
}
