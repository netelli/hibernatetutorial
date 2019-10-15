package com.study.hibernate.demo;

import com.study.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            displayStudents(students);

            students = session.createQuery("from Student s WHERE s.lastName='Dou'").getResultList();
            System.out.println("Dou students:");
            displayStudents(students);

            students=session.createQuery("from Student s where s.lastName='Dou' OR s.firstName='Daffy'").getResultList();
            System.out.println("Last name Dou or first name Daffy");
            displayStudents(students);

            students=session.createQuery("from Student s where s.email LIKE '%mail.com'").getResultList();
            System.out.println("Email contains 'mail.com'");
            displayStudents(students);

            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student :
                students) {
            System.out.println(student);
        }
    }
}
