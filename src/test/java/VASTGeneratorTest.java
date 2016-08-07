import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class VASTGeneratorTest {
    private final VASTGenerator generator = new VASTGenerator();

    @Test
    public void shouldReturnCorrectSampleVAST() throws Exception {
        String actual = TestUtils.serializeObject(generator.generateSampleVAST());
        String expected = TestUtils.readVastXmlAsString("src/test/resources/vastSample.xml");

        assertThat(actual, is(expected));
    }
}