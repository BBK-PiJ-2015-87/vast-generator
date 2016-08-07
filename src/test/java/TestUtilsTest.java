import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestUtilsTest {

    @Test
    public void shouldReadXMLFileIntoStringRemovingAllSpaces() throws Exception {
        String expected = "<one><two><three></three><three></three><three></three></two></one>";
        String actual = TestUtils.readVastXmlAsString("src/test/resources/XmlToString.xml");

        assertThat(actual, is(expected));
    }
}