import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.changeHamletToLeon();
        Pattern pat = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(hamletParser.getHamletData());
        Assert.assertFalse(mat.find());
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq();
        Pattern pat = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(hamletParser.getHamletData());
        Assert.assertTrue(mat.find());
    }

    @Test
    public void testFindHoratio() {
        int expected = 158;
        int actual = hamletParser.findHoratio();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet() {
        int expected = 472;
        int actual = hamletParser.findHamlet();
        Assert.assertEquals(expected,actual);
    }
}