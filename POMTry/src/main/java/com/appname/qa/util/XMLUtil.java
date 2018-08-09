package com.appname.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {

	Document xmlDocument;

	public XMLUtil(String path) throws ParserConfigurationException, SAXException, IOException {
		FileInputStream file = new FileInputStream(path);
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = fac.newDocumentBuilder();
		xmlDocument = db.parse(file);
	}

	public ArrayList<Object[]> getXMLData() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		NodeList nodes = xmlDocument.getElementsByTagName("Login");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node login = nodes.item(i);
		}

		return data;
	}

}
