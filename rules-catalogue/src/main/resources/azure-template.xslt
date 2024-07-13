<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:ns="http://windup.jboss.org/schema/jboss-ruleset">
    <xsl:output method="text" indent="no"/>
    <xsl:strip-space elements="*"/>
    
    <xsl:param name="catalogueName" select="'AppCAT'"/>
    <xsl:param name="filename" select="'unknown.xml'"/>
    <xsl:param name="includeHeader" select="'true'"/>
    
    <!-- Template for the part to be invoked once -->
    <xsl:template name="header">
        <xsl:text>&#10;</xsl:text>
        <xsl:text># </xsl:text>
        <xsl:value-of select="$catalogueName"/>
        <xsl:text> Rules &#10;</xsl:text>      
        <xsl:text>| ID  | Title | Category | Effort | Azure App Service | Azure Container Apps | Azure Kubernetes Service | Azure Spring Apps | Source file | &#10;</xsl:text>
        <xsl:text>| --- | ---   | ---      | ---    | ---               | ---                  | ---                      | ---               | ---         | &#10;</xsl:text>
    </xsl:template>
    
    <!-- Template for the part to be invoked multiple times -->
    <xsl:template name="body">
        <xsl:for-each select="//ns:rule">
            <xsl:text>| </xsl:text>
            <xsl:value-of select="@id"/>
            <xsl:text> | </xsl:text>
            <xsl:value-of select=".//ns:hint/@title"/>
            <xsl:text> | </xsl:text>
            <xsl:value-of select=".//ns:hint/@category-id"/>
            <xsl:text> | </xsl:text>
            <xsl:value-of select=".//ns:hint/@effort"/>
            <xsl:text> | </xsl:text>
            <xsl:choose>
                <xsl:when test="boolean(ancestor::ns:ruleset/ns:metadata/ns:targetTechnology[@id='azure-appservice'])">X</xsl:when>
                <xsl:otherwise></xsl:otherwise>
            </xsl:choose>
            <xsl:text> | </xsl:text>
            <xsl:choose>
                <xsl:when test="boolean(ancestor::ns:ruleset/ns:metadata/ns:targetTechnology[@id='azure-container-apps'])">X</xsl:when>
                <xsl:otherwise></xsl:otherwise>
            </xsl:choose>
            <xsl:text> | </xsl:text>
            <xsl:choose>
                <xsl:when test="boolean(ancestor::ns:ruleset/ns:metadata/ns:targetTechnology[@id='azure-aks'])">X</xsl:when>
                <xsl:otherwise></xsl:otherwise>
            </xsl:choose>
            <xsl:text> | </xsl:text>
            <xsl:choose>
                <xsl:when test="boolean(ancestor::ns:ruleset/ns:metadata/ns:targetTechnology[@id='azure-spring-apps'])">X</xsl:when>
                <xsl:otherwise></xsl:otherwise>
            </xsl:choose>
            <xsl:text> | </xsl:text>
            <xsl:value-of select="$filename"/>
            <xsl:text> |&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>
    
    <!-- Main template to orchestrate the transformations -->
    <xsl:template match="/">
        <!-- Call the header template once -->
        <xsl:if test="$includeHeader = 'true'">
            <xsl:call-template name="header"/>
        </xsl:if>
        
        <!-- Apply the rule template to each rule element -->
        <xsl:call-template name="body" />
    </xsl:template>
</xsl:stylesheet>