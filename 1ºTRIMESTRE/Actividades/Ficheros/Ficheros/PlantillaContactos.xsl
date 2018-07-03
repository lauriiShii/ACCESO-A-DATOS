<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match='/'>
        <html>
            <xsl:apply-templates/>
        </html>
    </xsl:template>
    <xsl:template match='Contactos'>
        <head>
            <title>Agenda</title>
        </head>
        <body>
            <h1>AGENDA</h1>
            <table border="1">
                <tr>
                    <th>NOMBRE</th>
                    <th>TELÉFONO</th>
                    <th>DIRECCIÓN</th>
                    <th>CÓDIGO POSTAL</th>
                    <th>FECHA DE NACIMIENTO</th>
                    <th>¿LE DEBO?</th>0
                    <th>DEUDA</th>
                </tr>
                <xsl:apply-templates select='Contacto'/>
            </table>
        </body>
    </xsl:template>
    <xsl:template match='Contactos'>
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match='nombre|telefono|direccion|codigoPostal|leDebo|deuda'>
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>