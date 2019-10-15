package com.study.hibernate.demo;

import com.study.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Paul", "Swing", "paul@mail.com");
            Student student2 = new Student("Marry", "Dou", "mary@mail.com");
            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(student);
            session.save(student2);

            session.getTransaction().commit();
            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
