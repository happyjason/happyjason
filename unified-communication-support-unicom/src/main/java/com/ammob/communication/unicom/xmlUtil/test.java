package com.ammob.communication.unicom.xmlUtil;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class test {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub

		//String xmlResult = "/Users/mac/Documents/appServer.xml";
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//DOM解析器工厂
//		factory.setIgnoringElementContentWhitespace(true);   
//		DocumentBuilder builder = factory.newDocumentBuilder();//获取DOM解析器
//		Document doc =  builder.parse(new File("/Users/mac/Documents/appServer.xml"));
//		System.out.println("test.main()"+doc.getElementsByTagName("Header"));
		new XMLParse();
	}

}
