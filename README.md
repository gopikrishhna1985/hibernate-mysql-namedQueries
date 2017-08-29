# hibernate-mysql-namedQueries
A Simple Hibernate MySQL example explaining the Named Queries Features

//Named Queries are used to work on the HQL Object

@NamedQueries(value = { 

    @NamedQuery(name = "student_findByFirstName", query = "from Student where firstName = ?"),

		@NamedQuery(name = "student_findByLastName", query = "from Student where lastName = ?"),
    
		@NamedQuery(name = "student_findAgeGreaterThan", query = "from Student where age > ?"), })

// Named Native Queries are used to work on the actual SQL Query language

// Mostly best used to run the Store Procedures

@NamedNativeQueries(value = {

		@NamedNativeQuery(name = "student_findBySchool", query = "select * from student where school = ?", resultClass = Student.class),
    
		@NamedNativeQuery(name = "student_findBySection", query = "select * from student where section = ?", resultClass = Student.class),
    
		@NamedNativeQuery(name = "student_findBySchoolAndSection", query = "select * from student where school = ? and section = ?", resultClass = Student.class) })

