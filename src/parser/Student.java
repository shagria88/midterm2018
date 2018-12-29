package parser;

import java.io.Serializable;

public class Student implements Serializable {

	/*
	 * Student class have 4 variables which will be constructed as Student Object into List<Student>.
	 */

	public String firstName;
	public String lastName;
	public int score;
	public int id;

	public Student(String shagria, String kabir, int i, int i1){}

	public Student(String firstName, String lastName, String score, String id) {
		this.firstName = this.firstName;
		this.lastName = this.lastName;
		this.score = this.score;
		this.id = this.id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@Override
	public String toString(){
		return "Student" + "("+"id= "+id+")"+ firstName+" "+lastName+" "+" Grade = "+score;
	}
	
}
