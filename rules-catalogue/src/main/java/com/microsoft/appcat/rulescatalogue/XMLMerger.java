package com.microsoft.appcat.rulescatalogue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLMerger {

    private static final String XSLT_DOCUMENT = """
            <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
            <xsl:output method="xml" indent="yes"/>

            <xsl:template match="/">
                <root>
                    %s
                </root>
            </xsl:template>
        </xsl:stylesheet>
        """;

    private static String XSLT_COPY = """
        <xsl:copy-of select="document('%s')/*"/>
        """;

    private static List<String> directories = List.of(
        //"../rules/rules-generated/",
        "rules/rules-reviewed/azure",
        "rules/rules-overridden-azure"
    );

    public static void main(String[] args) throws Exception {

        StringBuilder xsltCopies = new StringBuilder();

        for (String directoryPath : directories) {
            Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".xml") && !path.toString().endsWith("test.xml") && !path.toString().endsWith("copy.xml"))
                .forEach(file -> {
                    String filePath = file.toAbsolutePath().toString();
                    String xsltCopy = String.format(XSLT_COPY, filePath);
                    xsltCopies.append(xsltCopy);
                });
        }

        System.out.println(String.format(XSLT_DOCUMENT, xsltCopies));
    }
}