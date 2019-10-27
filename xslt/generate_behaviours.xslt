<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE xml>
<xsl:stylesheet version="2.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:zenta="http://magwas.rulez.org/zenta"
	xmlns:zentatools="java:org.rulez.magwas.zentatools.XPathFunctions"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" version="1.0" encoding="utf-8"
		indent="yes" omit-xml-declaration="yes" />

	<xsl:include href="xslt/functions.xslt" />

	<xsl:param name="modelbasename" />
	<xsl:param name="reponame" />
	<xsl:param name="github_org" />

    <xsl:variable name="zenta" select="document(concat($modelbasename,'.zenta'))"/>
    <xsl:variable name="rich" select="/"/>

	<xsl:template match="/">
		<xsl:variable name="behaviours">
			<tasks>
				<xsl:call-template name="behaviours" />
			</tasks>
		</xsl:variable>
		<xsl:result-document
			href="shippable/behaviours.txt">
			<xsl:copy-of
				select="zenta:writeTestcasesAsText($behaviours)" />
		</xsl:result-document>
		<xsl:result-document
			href="shippable/behaviours.xml">
			<xsl:copy-of select="$behaviours" />
		</xsl:result-document>
	</xsl:template>


    <xsl:function name="zenta:drawpic">
        <xsl:param name="picid"/>
            <xsl:variable name="picname" select="$zenta//element[@id=$picid]/@name"/>
            <xsl:variable name="piclink" select="concat(
                'https://repository.kodekonveyor.com/',
               $reponame,
               '/',
               $github_org,
               '/develop/pics/',
               $picid,
               '.png')"/>
            <xsl:variable name="doclink" select="concat(
                'https://repository.kodekonveyor.com/',
               $reponame,
               '/',
               $github_org,
               '/develop/index.html#',
               $picid)"/>
<xsl:text>
</xsl:text>
<xsl:value-of select="$picname"/>
[![<xsl:value-of select="$picname"/>](<xsl:value-of select="$piclink"/>)](<xsl:value-of select="$doclink"/>)
    </xsl:function>

	<xsl:function name="zenta:writeTestcasesAsText">
		<xsl:param name="behaviours" />
		<xsl:for-each select="$behaviours//task">
----------------------------------------------------------------------------
Behaviour: <xsl:value-of select="concat(@service, '/', @behaviour)" />

Annotations for the test cases:

    @TestedBehaviour("<xsl:value-of select="@behaviour" />")
    @TestedService("<xsl:value-of select="@service" />")

The production code is at <xsl:value-of select="concat(@package, '.', @service)" />.java
You should probably start at <xsl:value-of select="concat(@package, '.', @service)" />Tests.java

<xsl:copy-of select="$zenta//element[@id=current()/behaviour/element/@id]/documentation/(*|text())"/>

Relevant views:
            <xsl:variable name="servicepics" select="$zenta//element[.//child[@zentaElement=current()/service/element/@id]]/@id"/>
            <xsl:variable name="behaviourpics" select="$zenta//element[.//child[@zentaElement=current()/behaviour/element/@id]]/@id"/>
            <xsl:for-each select="distinct-values($behaviourpics intersect $servicepics)">
<xsl:copy-of select="zenta:drawpic(.)"/>
            </xsl:for-each>

More about the service:
            <xsl:for-each select="distinct-values($servicepics except $behaviourpics)">
                <xsl:copy-of select="zenta:drawpic(.)"/>
            </xsl:for-each>
More about the behaviour:
            <xsl:for-each select="distinct-values($behaviourpics except $servicepics)">
                <xsl:copy-of select="zenta:drawpic(.)"/>
            </xsl:for-each>

If you have questions, see the [FAQ](https://kodekonveyor.com/coder-faq/), ask on the [Telegram channel](https://t.me/joinchat/D1deE0loEBoFGvyDssWRuw) or ask your mentor.

		</xsl:for-each>
	</xsl:function>

    <xsl:function name="zenta:fullpackageP">
        <xsl:param name="package"/>
        <xsl:if test="$package">
            <xsl:variable name="parent" select="zenta:fullpackageP(zenta:neighbours($rich,$package,'contains,2')[@xsi:type='Package'])"/>
            <xsl:choose>
                <xsl:when test="$parent">
                    <xsl:value-of select="concat($parent, '.', $package/@name)"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$package/@name"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>
    </xsl:function>

    <xsl:function name="zenta:fullpackage">
        <xsl:param name="service"/>
        <xsl:variable name="parent" select="zenta:neighbours($rich,$service,'contains,2')"/>
        <xsl:choose>
            <xsl:when test="$parent/@xsi:type='Package'">
                <xsl:copy-of select="zenta:fullpackageP($parent)"/>
            </xsl:when>
            <xsl:when test="$parent/@xsi:type='Process Step'">
                <xsl:copy-of select="zenta:fullpackageP($parent)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:copy-of select="zenta:fullpackage(zenta:neighbours($rich,$service,'is implemented by/implements,2'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

	<xsl:template name="behaviours">
		<xsl:variable name="root" select="/" />
		<xsl:for-each
			select="//element[@template='false' and (@xsi:type='Behaviour')]">
            <xsl:variable name="behaviour" select="."/>
            <xsl:for-each select="zenta:neighbours(/,.,'is implemented by/implements,1')">
                <task>
                    <xsl:attribute name="service" select="@name"/>
                    <xsl:attribute name="behaviour" select="$behaviour/@name"/>
                    <xsl:attribute name="package" select="zenta:fullpackage(.)"/>
                    <service><xsl:copy-of select="."/></service>
                    <behaviour><xsl:copy-of select="$behaviour"/></behaviour>
                </task>
            </xsl:for-each>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>

