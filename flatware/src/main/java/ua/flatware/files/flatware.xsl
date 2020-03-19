<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:erp="http://flatware.ua/"
                exclude-result-prefixes="erp">
    <xsl:template match="erp:flatware">
        <html>
            <body>
                <h1 align="center">Flatware</h1>
                <table border="1" align="center">
                    <tr bgcolor="#a9f5e8">
                        <th>Type</th>
                        <th>Length(cm)/Volume(ml)</th>
                        <th>Active Part Material</th>
                        <th>Handle Material</th>
                        <th>Origin</th>
                        <th>Value</th>
                    </tr>

                    <xsl:for-each select="erp:ware">
                        <xsl:sort select="erp:type" case-order="lower-first"/>
                        <xsl:sort select="erp:visual/erp:active-part/*/@length" data-type="number" case-order="upper-first"/>
                        <xsl:sort select="erp:visual/erp:active-part/*/@volume" data-type="number" case-order="upper-first"/>

                        <tr>
                            <td align="center">
                                <xsl:value-of select="erp:type"/>
                            </td>

                            <xsl:choose>
                                <xsl:when test="erp:visual/erp:active-part/erp:blade/@length">
                                    <td align="center">
                                        <xsl:value-of select="erp:visual/erp:active-part/erp:blade/@length"/>
                                    </td>
                                </xsl:when>
                                <xsl:when test="erp:visual/erp:active-part/erp:prong/@length">
                                    <td align="center">
                                        <xsl:value-of select="erp:visual/erp:active-part/erp:prong/@length"/>
                                    </td>
                                </xsl:when>
                                <xsl:when test="erp:visual/erp:active-part/erp:scoop/@volume">
                                    <td align="center">
                                        <xsl:value-of select="erp:visual/erp:active-part/erp:scoop/@volume"/>
                                    </td>
                                </xsl:when>
                            </xsl:choose>

                            <xsl:choose>
                                <xsl:when
                                        test="erp:visual/erp:active-part/erp:blade/erp:material/erp:steel/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:active-part/erp:blade/erp:material/erp:steel/@material-type"/>
                                    </td>
                                </xsl:when>
                                <xsl:when
                                        test="erp:visual/erp:active-part/erp:blade/erp:material/erp:wood/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:active-part/erp:blade/erp:material/erp:wood/@material-type"/>
                                    </td>
                                </xsl:when>

                                <xsl:when
                                        test="erp:visual/erp:active-part/erp:prong/erp:material/erp:steel/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:active-part/erp:prong/erp:material/erp:steel/@material-type"/>
                                    </td>
                                </xsl:when>
                                <xsl:when
                                        test="erp:visual/erp:active-part/erp:prong/erp:material/erp:wood/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:active-part/erp:prong/erp:material/erp:wood/@material-type"/>
                                    </td>
                                </xsl:when>

                                <xsl:when
                                        test="erp:visual/erp:active-part/erp:scoop/erp:material/erp:steel/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:active-part/erp:scoop/erp:material/erp:steel/@material-type"/>
                                    </td>
                                </xsl:when>
                                <xsl:when
                                        test="erp:visual/erp:active-part/erp:scoop/erp:material/erp:wood/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:active-part/erp:scoop/erp:material/erp:wood/@material-type"/>
                                    </td>
                                </xsl:when>
                            </xsl:choose>

                            <xsl:choose>
                                <xsl:when test="erp:visual/erp:handle/erp:material/erp:steel/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:handle/erp:material/erp:steel/@material-type"/>
                                    </td>
                                </xsl:when>
                                <xsl:when test="erp:visual/erp:handle/erp:material/erp:wood/@material-type">
                                    <td align="center">
                                        <xsl:value-of
                                                select="erp:visual/erp:handle/erp:material/erp:wood/@material-type"/>
                                    </td>
                                </xsl:when>
                            </xsl:choose>

                            <td align="center">
                                <xsl:value-of select="erp:origin"/>
                            </td>
                            <td align="center">
                                <xsl:value-of select="erp:value"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
