<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:output method="text" indent="yes"/>

    <xsl:template match="/">
        | ID | Title | Category | Azure Spring Apps | Azure AKS | Azure App Service | Azure Container Apps
        | --- | --- | --- | --- | --- | --- | --- |
        <xsl:for-each select="//rule">
            | <xsl:value-of select="id"/> | <xsl:value-of select="title"/> | <xsl:value-of select="category"/> | <xsl:choose><xsl:when test="targetTechnologies/targetTechnology='azure-spring-apps'">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose> | <xsl:choose><xsl:when test="targetTechnologies/targetTechnology='azure-aks'">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose> | <xsl:choose><xsl:when test="targetTechnologies/targetTechnology='azure-appservice'">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose> | <xsl:choose><xsl:when test="targetTechnologies/targetTechnology='azure-container-apps'">X</xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose> |
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>