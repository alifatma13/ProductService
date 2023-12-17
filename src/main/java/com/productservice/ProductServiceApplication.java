package com.productservice;

import com.productservice.inheritencerelations.singletable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    /*	private MentorRepository mentorRepository;
        private StudentRepository studentRepository;
        private UserRepository userRepository;

        ProductServiceApplication (@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
                                   StudentRepository studentRepository, UserRepository userRepository){
            this.mentorRepository = mentorRepository;
            this.studentRepository = studentRepository;
            this.userRepository = userRepository;
        }*/
    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private MentorRepository mentorRepository;

    ProductServiceApplication (@Qualifier("st_userRepository") UserRepository userRepository,
                               @Qualifier("st_studentRepository") StudentRepository studentRepository,
                               @Qualifier("st_mentorrepository") MentorRepository mentorRepository) {
        this.userRepository = userRepository;
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
        System.out.println("Hello World");
    }


    @Override
    public void run(String... args) throws Exception {
/*
		Mentor mentor = new Mentor();
		mentor.setName("Fatma");
		mentor.setAvgRating(4.6);
		mentor.setEmail("fatma.ali@gmail.com");
		mentorRepository.save(mentor);

		Student student = new Student();
		student.setName("Abhishek");
		student.setEmail("abhishek@gmail.com");
		student.setPsp(89.0);
		studentRepository.save(student);

		User user = new User();
		user.setName("Arif");
		user.setEmail("arif@gmail.com");
		userRepository.save(user);

		//Get all the Users.
        List<User> users = userRepository.findAll();
        for (User user1 : users) {
            System.out.println(user1.toString());
        }

*/
		Mentor mentor = new Mentor();
		mentor.setName("Fatma");
		mentor.setAvgRating(4.6);
		mentor.setEmail("fatma.ali@gmail.com");
		mentorRepository.save(mentor);

		Student student = new Student();
		student.setName("Abhishek");
		student.setEmail("abhishek@gmail.com");
		student.setPsp(89.0);
		studentRepository.save(student);

		User user = new User();
		user.setName("Arif");
		user.setEmail("arif@gmail.com");
		userRepository.save(user);

    }
}
