/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.conexao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import jdk.internal.org.xml.sax.InputSource;
import jdk.internal.org.xml.sax.XMLReader;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Wanderlei
 */
public class Conexao {

    private static Connection conexao;

    public static Connection getConexao() {

        try {
            

            String dsn = "jdbc:mysql://localhost:3306/restaurante";
            String dbuser = "restaurante";
            String dbpass = "restaurante";

            Class.forName("com.mysql.jdbc.Driver");

            if (conexao == null) {
                conexao = DriverManager.getConnection(dsn, dbuser, dbpass);
            }

        } catch ( Exception ex){
             System.err.println(ex.getMessage());
        }
        return conexao;
    }
}
