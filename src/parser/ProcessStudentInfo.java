package parser;

import databases.ConnectToMongoDB;
import databases.ConnectToSqlDB;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class ProcessStudentInfo {



	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//Path of XML data to be read.
		String pathSelenium  = System.getProperty("user.dir") + "/src/parser/selenium.xml";
		String pathQtp = System.getProperty("user.dir") + "/src/parser/qtp.xml";
		String tag = "id";
		//Create ConnectToSqlDB Object
		ConnectToMongoDB connect = new ConnectToMongoDB();
		//Declare a Map with List<String> into it.
		Map<String,List<Student>> list = new LinkedHashMap<String,List<Student>>();

				/*Declare 2 ArrayList with Student data type to store Selenium student into one of the ArrayList and
				  Qtp student into another ArrayList. */

		List<Student> seleniumStudents = new ArrayList<Student>();
		List<Student> qtpStudents = new ArrayList<Student>();

		//Create XMLReader object.
		XmlReader xmlReader = new XmlReader();


		//Parse Data using parseData method and then store data into Selenium ArrayList.
		seleniumStudents = xmlReader.parseData(tag, pathSelenium);

		//Parse Data using parseData method and then store data into Qtp ArrayList.
		qtpStudents = xmlReader.parseData(tag, pathQtp);

		//add Selenium ArrayList data into map.
		list.put("Selenium Students", seleniumStudents);

		//add Qtp ArrayList data into map.
		list.put("QTP Students", qtpStudents);


		//Retrieve map data and display output.
		for (Map.Entry<String, List<Student>> value : list.entrySet()) {
			List<Student> students = list.get(value.getKey());
			System.out.println("\n" + value.getKey() + " Students");
			for (Student s : students) {
				String id = s.getId();
				String firstname = s.getFirstName();
				String lastname = s.getLastName();
				String grade = s.getScore();
				System.out.println("Student (id=" + id + ") '" + firstname + "'  '" + lastname + "       \t'Grade= " + grade);
			}


			//Store Qtp data into Qtp table in Database
			connect.insertIntoMongoDB(seleniumStudents, "qtp");
			//connectToSqlDB.insertDataFromArrayListToMySql(seleniumStudents, "qtp","studentList");

			//Store Selenium data into Selenium table in Database
			connect.insertIntoMongoDB(qtpStudents, "selenium");
			//Retrieve Qtp students from Database
			List<Student> stList = connect.readStudentListFromMongoDB("qtp");
			for (Student st : stList) {
				System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getScore() + " " + st.getId());
			}

			//Retrieve Selenium students from Database

			List<Student> st1List = connect.readStudentListFromMongoDB("selenium");
			for (Student st : st1List) {
				System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getScore() + " " + st.getId());
			}
		}
	}
}
