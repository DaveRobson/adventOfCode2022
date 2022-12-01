package uk.co.robson.adventofcode2022.common;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicFileParser {

    public List<String> parseFile(String name) throws Exception {
        String[] rawLines = loadInputData(name).split("\n");
        return Arrays.stream(rawLines)
                .collect(Collectors.toList());
    }

    public <T> List<T> parseFile(String name, Function<String, T> mappingFunction) throws Exception {
        String[] rawLines = loadInputData(name).split("\n");
        return Arrays.stream(rawLines)
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private String loadInputData(String name) throws Exception {
        InputStream stream = BasicFileParser.class.getClassLoader().getResourceAsStream(name);
        return IOUtils.toString(stream, StandardCharsets.UTF_8);
    }

}
