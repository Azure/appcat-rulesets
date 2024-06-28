<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns="http://windup.jboss.org/schema/jboss-ruleset">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <root>
            <xsl:for-each select="//ns:ruleset">
                <rule>
                    <id><xsl:value-of select="ns:rules/ns:rule/@id"/></id>
                    <title><xsl:value-of select=".//ns:hint/@title"/></title>
                    <category><xsl:value-of select=".//ns:hint/@category-id"/></category>
                    <targetTechnologies>
                        <xsl:for-each select="ns:metadata/ns:targetTechnology">
                            <targetTechnology><xsl:value-of select="@id"/></targetTechnology>
                        </xsl:for-each>
                    </targetTechnologies>
                </rule>
            </xsl:for-each>
        </root>
    </xsl:template>
</xsl:stylesheet>
