package com.microsoft.appcat.rulescatalogue;

import javax.xml.transform.stream.StreamSource;

public record Catalogue(String name, String directoryPath, StreamSource xsltTemplate) {

}
