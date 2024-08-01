package com.microsoft.appcat.rulescatalogue;

import javax.xml.transform.stream.StreamSource;

public class Catalogue {

    private final String name;
    private final String directoryPath;
    private final StreamSource xsltTemplate;

    public Catalogue(String name, String directoryPath, StreamSource xsltTemplate) {
        this.name = name;
        this.directoryPath = directoryPath;
        this.xsltTemplate = xsltTemplate;
    }

    public String name() {
        return name;
    }

    public String directoryPath() {
        return directoryPath;
    }

    public StreamSource xsltTemplate() {
        return xsltTemplate;
    }

}