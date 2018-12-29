package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * This XmlReader class are using DOM parser to read data from XML.
 */

public class XmlReader {

	public List<Student> parseData(String tagName,String path) throws ParserConfigurationException, SAXException, IOException{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File file = new File(path);
		Document doc = builder.parse(file);
		NodeList nodeList = doc.getDocumentElement().getChildNodes();
		List<Student> list = new ArrayList<>();
		for(int i=0;i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			if(node instanceof Element){
				Student student = new Student();
				student.id = Integer.parseInt(node.getAttributes().getNamedItem(tagName).getNodeValue());
				NodeList childNodes = node.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++){
					Node cNode = childNodes.item(j);
					if(cNode instanceof Element){
						String content = cNode.getLastChild().getTextContent().trim();
						String data = cNode.getNodeName();
						switch(data){
							case "firstName":
								student.firstName = content;
								break;
							case "lastName":
								student.lastName = content;
								break;
							case "score":
								student.score = Integer.parseInt(convertIntToChar(content));
								break;
						}
					}
				}
				list.add(student);
			}

		}
		return list;
	}



	public String convertIntToChar(String score){
		String grade = "";
		int grades = Integer.parseInt(score);
		if (grades >= 94 && grades <=100) {
			grade = "A+";
		} else if (grades >= 90 && grades <=93) {
			grade = "A";
		} else if (grades >= 85 && grades <=89) {
			grade = "B+";
		} else if (grades >= 80 && grades <=84) {
			grade = "B";
		}else if (grades >= 70 && grades <=79) {
			grade = "C";
		}else if (grades >= 65 && grades <= 69) {
			grade = "D";
		}else{
			grade = "F";
		}


		return grade;
	}

}