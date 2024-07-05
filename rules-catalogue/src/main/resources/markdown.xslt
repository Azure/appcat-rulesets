<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:ns="http://windup.jboss.org/schema/jboss-ruleset">
    <xsl:output method="text" indent="no"/>
    <xsl:strip-space elements="*"/>
    
    <xsl:param name="catalogueName" select="'AppCAT'"/>
    <xsl:param name="filename" select="'unknown.xml'"/>
    <xsl:param name="includeHeader" select="'true'"/>
    <xsl:param name="templateId" select="'generic'"/>
    
    <!-- Template for the part to be invoked once -->
    <xsl:template name="header">
        <xsl:text># </xsl:text>
        <xsl:value-of select="$catalogueName"/>
        <xsl:text> Rules &#13;&#10;&#13;&#10;</xsl:text>      
        <xsl:text>| ID  | Title | Category | Effort | Azure App Service | Azure Container Apps | Azure Kubernetes Service | Azure Spring Apps | Source file | &#13;&#10;</xsl:text>
        <xsl:text>| --- | ---   | ---      | ---    | ---               | ---                  | ---                      | ---               | ---         | &#13;&#10;</xsl:text>
    </xsl:template>
    
    <!-- Template for the part to be invoked multiple times -->
    <xsl:template name="azure">
        <xsl:text>| </xsl:text>
        <xsl:value-of select=".//ns:rule/@id"/>
        <xsl:text> | </xsl:text>
        <xsl:value-of select=".//ns:hint/@title"/>
        <xsl:text> | </xsl:text>
        <xsl:value-of select=".//ns:hint/@category-id"/>
        <xsl:text> | </xsl:text>
        <xsl:value-of select=".//ns:hint/@effort"/>
        <xsl:text> | </xsl:text>
        <xsl:choose><xsl:when test="boolean(.//ns:targetTechnology[@id='azure-appservice'])">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose>
        <xsl:text> | </xsl:text>
        <xsl:choose><xsl:when test="boolean(.//ns:targetTechnology[@id='azure-container-apps'])">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose>
        <xsl:text> | </xsl:text>
        <xsl:choose><xsl:when test="boolean(.//ns:targetTechnology[@id='azure-aks'])">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose>
        <xsl:text> | </xsl:text>
        <xsl:choose><xsl:when test="boolean(.//ns:targetTechnology[@id='azure-spring-apps'])">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose>
        <xsl:text> | </xsl:text>
        <xsl:value-of select="$filename"/>
        <xsl:text> |&#13;&#10;</xsl:text>
    </xsl:template>
    
    <!-- Main template to orchestrate the transformations -->
    <xsl:template match="/">
        <!-- Call the header template once -->
        <xsl:if test="$includeHeader = 'true'">
            <xsl:call-template name="header"/>
        </xsl:if>
        
        <!-- Apply the rule template to each rule element -->
        
        <xsl:call-template name="azure" />
    </xsl:template>
</xsl:stylesheet>