package com.hibernate.startup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//Named Queries are used to work on the HQL Object
@NamedQueries(value = { @NamedQuery(name = "student_findByFirstName", query = "from Student where firstName = ?"),
		@NamedQuery(name = "student_findByLastName", query = "from Student where lastName = ?"),
		@NamedQuery(name = "student_findAgeGreaterThan", query = "from Student where age > ?"), })

// Named Native Queries are used to work on the actual SQL Query language
// Mostly best used to run the Store Procedures
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "student_findBySchool", query = "select * from student where school = ?", resultClass = Student.class),
		@NamedNativeQuery(name = "student_findBySection", query = "select * from student where section = ?", resultClass = Student.class),
		@NamedNativeQuery(name = "student_findBySchoolAndSection", query = "select * from student where school = ? and section = ?", resultClass = Student.class) })
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String section;
	private String school;

	public Student() {

	}

	public Student(String firstName, String lastName, int age, String section, String school) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.section = section;
		this.school = school;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", section=" + section + ", school=" + school + "]";
	}

}
