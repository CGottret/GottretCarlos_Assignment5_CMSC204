import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MorseCodeConverter_GFA_Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConvertToEnglishString() {
        String converter1 = MorseCodeConverter
                .convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
        assertEquals("hello world", converter1);
    }

}