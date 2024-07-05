package com.microsoft.appcat.rulescatalogue;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
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

    static String XSLT_MARKDOWN_TEMPLATE = "rules-catalogue/src/main/resources/markdown.xslt";

    public static void main(String[] args) {

        var catalogues = List.of(
                new Catalogue("Azure", List.of(
                        "rules/rules-reviewed/azure",
                        "rules/rules-overridden-azure"), "azure"),
                new Catalogue("OpenJDK 11", List.of(
                        "rules/rules-reviewed/openjdk11/openjdk8"), "generic"),
                new Catalogue("OpenJDK 17", List.of(
                        "rules/rules-reviewed/openjdk17/openjdk11"), "generic"),
                new Catalogue("OpenJDK 21", List.of(
                        "rules/rules-reviewed/openjdk21/openjdk17"), "generic"),
                new Catalogue("Cloud Readiness", List.of(
                        "rules/rules-reviewed/cloud-readiness"), "generic"),
                new Catalogue("Linux", List.of(
                        "rules/rules-reviewed/os/windows"), "generic"));

        var markdownFile = new File("rules-catalogue/target/rules-catalogue.md");
        if (markdownFile.exists()) {
            markdownFile.delete();
        }

        try (FileOutputStream outputFile = new FileOutputStream(markdownFile, true)) {
            // 1. Instantiate a TransformerFactory.
            var factory = TransformerFactory.newInstance();

            // 2. Use the TransformerFactory to create a Transformer for the XSLT.
            var xslt = new StreamSource("rules-catalogue/src/main/resources/markdown.xslt");
            var transformer = factory.newTransformer(xslt);

            // Create a Result object to capture the output.
            var output = new StreamResult(outputFile);

            boolean headerWritten = false;

            // start loop here
            for (var entry : catalogues) {
                var catalogueName = entry.name();
                var directories = entry.directories();

                transformer.setParameter("catalogueName", catalogueName);
                transformer.setParameter("templateId", entry.templateId());

                for (String directoryPath : directories) {
                    var directory = new File(directoryPath);

                    processDirectory(transformer, output, headerWritten, directoryPath, directory);
                }
            }
            System.out.println("Transformation completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(Transformer transformer, StreamResult output, boolean headerWritten,
            String directoryPath, File directory) throws Exception {
        if (!directory.exists()) {
            LOGGER.warning("Directory does not exist: " + directoryPath);
            return;
        }

        // Process the XML files containing rulesets
        for (var file : directory.listFiles()) {
            if (isValidRulesetFile(file)) {
                LOGGER.info("Processing file: " + file.getAbsolutePath());
                transformer.setParameter("filename", file.getName());
                transformer.transform(new StreamSource(file), output);

                if (!headerWritten) {
                    headerWritten = true;
                    transformer.setParameter("includeHeader", "false");
                }
            } else if (file.isDirectory() && !file.getName().equals("tests")) {
                processDirectory(transformer, output, headerWritten, directoryPath, file);
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
