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
        <xsl:text>| ID  | Title | Category | Effort | Source file | &#10;</xsl:text>
        <xsl:text>| --- | ---   | ---      | ---    | ---         | &#10;</xsl:text>
    </xsl:template>
    
    <!-- Template for the part to be invoked multiple times -->
    <xsl:template name="body">
        <xsl:for-each select="//ns:rule">
            <xsl:text>| </xsl:text>
            <xsl:value-of select="@id" />
            <xsl:text> | </xsl:text>
            <!-- Check for hint or classification -->
            <xsl:choose>
                <!-- If hint exists -->
                <xsl:when test=".//ns:hint">
                    <xsl:value-of select=".//ns:hint/@title"/>
                    <xsl:text> | </xsl:text>
                    <xsl:value-of select=".//ns:hint/@category-id"/>
                    <xsl:text> | </xsl:text>
                    <xsl:value-of select=".//ns:hint/@effort"/>
                </xsl:when>
                <!-- If classification exists -->
                <xsl:when test=".//ns:classification">
                    <xsl:value-of select=".//ns:classification/@title"/>
                    <xsl:text> | </xsl:text>
                    <xsl:value-of select=".//ns:classification/@category-id"/>
                    <xsl:text> | </xsl:text>
                    <xsl:value-of select=".//ns:classification/@effort"/>
                </xsl:when>
                <!-- Default case if neither exists -->
                <xsl:otherwise>
                    <xsl:text>Not Available | Not Available | Not Available</xsl:text>
                </xsl:otherwise>
            </xsl:choose>
            <xsl:text> | </xsl:text>
            <xsl:value-of select="$filename"/>
            <xsl:text> | &#10;</xsl:text>
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