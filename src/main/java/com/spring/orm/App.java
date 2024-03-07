package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.sql.Update;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
		//insert student
//        Student student = new Student(2,"hta","abc");
//        
//        int r = studentDao.insert(student);
//        System.out.println("inserted"+r);

		
		// select student

//        Student r =studentDao.getById(2);
//        System.out.println(r);

		// select all

//        List<Student> student = studentDao.getAllStudents();
//        
//        for(Student s :student) {
//        	System.out.println(s);
//        }

		//update student
//        Student updatedStudent = new Student();
//        updatedStudent.setId(2);  // Assuming the ID of the student you want to update is 2
//        updatedStudent.setName("hem");
//        updatedStudent.setCity("aabb");
//
//        // Update the student in the database
//        int updatedStudentId = studentDao.updateStudent(updatedStudent);
//        System.out.println("Updated student with ID: " + updatedStudentId)

		//detele student
//       int deletestd =2;
//       Student student = studentDao.deleteStudent(deletestd);
//       
//       System.out.println("deleted successful"+student);
//       

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {
			System.out.println("Press 1 to add new student");
			System.out.println("Press 2 to display single student");
			System.out.println("Press 3 to display all student");
			System.out.println("Press 4 to update student");
			System.out.println("Press 5 to delete students");
			System.out.println("Press 6 to exit ");
			System.out.println("*******************************");
			System.out.println();

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add new student
					System.out.println();
					System.out.println("Enter id");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("Enter user name");
					String uname = br.readLine();

					System.out.println("Enter city");
					String ucity = br.readLine();

					Student s = new Student();
					s.setId(uid);
					s.setName(uname);
					s.setCity(ucity);

					int r = studentDao.insert(s);
					System.out.println();
					System.out.println("******************************");
					System.out.println("data insertition successful");
					System.out.println("INSERTED DATA");
					System.out.println("Id:" + s.getId());
					System.out.println("Name:" + s.getName());
					System.out.println("City:" + s.getCity());
					System.out.println("********************************");
					
					System.out.println();
					break;
					
				case 2:
					// display single student
					System.out.println();
					System.out.println("Enter id:");
					int sid = Integer.parseInt(br.readLine());
					Student s2 = studentDao.getById(sid);
					System.out.println("Id:" + s2.getId());
					System.out.println("Name:" + s2.getName());
					System.out.println("City:" + s2.getCity());
					System.out.println("********************************");
					System.out.println();
					break;
					
				case 3:
					// display all student
					List<Student> student = studentDao.getAllStudents();
					for (Student s1 : student) {
						System.out.println();
						System.out.println("Id:" + s1.getId());
						System.out.println("Name:" + s1.getName());
						System.out.println("City:" + s1.getCity());
						System.out.println("********************************");
						System.out.println();
					}
					break;


				case 4:
					// update student
					System.out.println();
					System.out.println("Enter id of student to update:");
					int upid = Integer.parseInt(br.readLine());

					System.out.println("Enter user name");
					String upname = br.readLine();

					System.out.println("Enter city");
					String upcity = br.readLine();

					Student updatedStudent = new Student();
					updatedStudent.setId(upid);
					updatedStudent.setName(upname);
					updatedStudent.setCity(upcity);

					int upresult = studentDao.updateStudent(updatedStudent);

					System.out.println();
					System.out.println("Data updattion successful");
					System.out.println("UPDATED DATA");
					System.out.println("Id:" + updatedStudent.getId());
					System.out.println("Name:" + updatedStudent.getName());
					System.out.println("City:" + updatedStudent.getCity());
					System.out.println("********************************");
					System.out.println();

					break;
					
				case 5:
					// delete student
					System.out.println();
					System.out.println("Enter id to be deleted:");
					int did = Integer.parseInt(br.readLine());
					Student deletestd = studentDao.deleteStudent(did);
					System.out.println("deletetion successful");
					System.out.println("********************************");
					System.out.println();

					break;

				case 6:
					// display all student
					go = false;
					break;

				}
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}

		System.out.println("Exited");
	}
}
