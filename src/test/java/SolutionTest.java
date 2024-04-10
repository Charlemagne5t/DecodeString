import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test6(){
        String s = "1[2[jk]e1[f]]";
        String expected = "jkjkef";
        String actual = new Solution().decodeString(s);
        Assert.assertEquals(expected, actual);
    }
}
