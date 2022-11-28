package ru.ibra.cbrrate.parser;

import org.junit.jupiter.api.Test;
import ru.ibra.cbrrate.model.CurrencyRate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRateParserXmlTest {

    @Test
    void parse() throws IOException, URISyntaxException {
        CurrencyRateParserXml parser = new CurrencyRateParserXml();
        URI uri = ClassLoader.getSystemResource("cbr_response.xml").toURI();
        String ratesXml = Files.readString(Paths.get(uri), Charset.defaultCharset());

        //when
        List<CurrencyRate> rates = parser.parse(ratesXml);

        System.out.println("a");
    }
}