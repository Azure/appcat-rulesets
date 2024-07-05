package com.microsoft.appcat.rulescatalogue;

import java.util.List;

public record Catalogue(String name, List<String> directories, String templateId) {
    
}
