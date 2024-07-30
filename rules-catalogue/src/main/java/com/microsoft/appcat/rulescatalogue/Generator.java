package com.microsoft.appcat.rulescatalogue;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Generator {

    static Logger LOGGER = Logger.getLogger(Generator.class.getName());

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }

    static String XSLT_MARKDOWN_TEMPLATE_PATH = "rules-catalogue/src/main/resources/";

    static StreamSource XSLT_AZURE_TEMPLATE = new StreamSource(XSLT_MARKDOWN_TEMPLATE_PATH + "azure-template.xslt");
    static StreamSource XSLT_GENERIC_TEMPLATE = new StreamSource(XSLT_MARKDOWN_TEMPLATE_PATH + "generic-template.xslt");

    static String OUTPUT = "rules-catalogue/target/rules-catalogue.md";

    static TransformerFactory factory = TransformerFactory.newInstance();

    public static void main(String[] args) {

        if (args.length == 1) {
            OUTPUT = args[0];
        }

        var catalogues = List.of(
                new Catalogue("Azure", "rules/rules-reviewed/azure", XSLT_AZURE_TEMPLATE),
                new Catalogue("OpenJDK 11", "rules/rules-reviewed/openjdk11/openjdk8", XSLT_GENERIC_TEMPLATE),
                new Catalogue("OpenJDK 17", "rules/rules-reviewed/openjdk17/openjdk11", XSLT_GENERIC_TEMPLATE),
                new Catalogue("OpenJDK 21", "rules/rules-reviewed/openjdk21/openjdk17", XSLT_GENERIC_TEMPLATE),
                new Catalogue("Cloud Readiness", "rules/rules-reviewed/cloud-readiness", XSLT_GENERIC_TEMPLATE),
                new Catalogue("Linux", "rules/rules-reviewed/os/windows", XSLT_GENERIC_TEMPLATE),
                new Catalogue("Azure (overridden rules)", "rules/rules-overridden-azure", XSLT_AZURE_TEMPLATE));

        var markdownFile = new File(OUTPUT);
        if (markdownFile.exists()) {
            markdownFile.delete();
        }

        try (FileOutputStream outputFile = new FileOutputStream(markdownFile, true)) {
            // Create a Result object to capture the output.
            var output = new StreamResult(outputFile);

            // start loop here
            for (var entry : catalogues) {
                // log which catalogue is being parsed
                LOGGER.info("Parsing catalogue: " + entry.name());
                parseCatalogue(output, entry);
            }
            LOGGER.info("Transformation completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseCatalogue(StreamResult output,
            Catalogue entry) throws Exception {

        var transformer = factory.newTransformer(entry.xsltTemplate());
        var catalogueName = entry.name();
        var directoryPath = entry.directoryPath();

        boolean includeHeader = true;
        transformer.setParameter("catalogueName", catalogueName);
        transformer.setParameter("includeHeader", "true");

        var directory = new File(directoryPath);
        processDirectory(entry, transformer, output, includeHeader, directoryPath, directory);
    }

    private static void processDirectory(Catalogue entry, Transformer transformer, StreamResult output,
            boolean includeHeader,
            String directoryPath, File directory) throws Exception {
        if (!directory.exists()) {
            LOGGER.warning("Directory does not exist: " + directoryPath);
            return;
        }

        // Process the XML files containing rulesets
        for (var file : directory.listFiles()) {
            if (isValidRulesetFile(file)) {
                LOGGER.info("Processing file: " + file.getAbsolutePath());
                var filename = file.getName();
                transformer.setParameter("filename", filename);

                transformer.transform(new StreamSource(file), output);

                if (includeHeader) {
                    includeHeader = false;
                    transformer.setParameter("includeHeader", "false");
                }
            } else if (file.isDirectory() && !file.getName().equals("tests")) {
                processDirectory(entry, transformer, output, includeHeader, directoryPath, file);
            }
        }
    }

    private static boolean isValidRulesetFile(File file) {
        return file.isFile() &&
                file.getName().endsWith(".windup.xml") &&
                !file.getName().endsWith("test.xml") &&
                !file.getName().endsWith("copy.xml");
    }

}
