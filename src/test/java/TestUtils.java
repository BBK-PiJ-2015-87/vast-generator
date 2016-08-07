import com.famlabs.vast.VAST;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class TestUtils {

    public static String readVastXmlAsString(String fileName) throws IOException {
        List<String> stringList= FileUtils.readLines(new File(fileName), "UTF-8");

        return stringList.stream()
                .map(s -> s.trim())
                .collect(joining());
    }

    public static VAST getVastFromString(String vast) throws IOException {
        return provideConfiguredXmlMapper().readValue(vast, VAST.class);
    }

    public static <T> String serializeObject(T toSerialize) throws JsonProcessingException {
        return provideConfiguredXmlMapper().writeValueAsString(toSerialize);
    }

    private static XmlMapper provideConfiguredXmlMapper(){
        XmlMapper mapper = new XmlMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(mapper.getTypeFactory());
        mapper.setAnnotationIntrospector(introspector);

        return mapper;
    }
}
