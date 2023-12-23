package com.productservice;

import com.productservice.models.Category;
import com.productservice.models.Price;
import com.productservice.models.Product;
import com.productservice.repositories.CategoryRepository;
import com.productservice.repositories.PriceRepository;
import com.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    /*	private MentorRepository mentorRepository;
        private StudentRepository studentRepository;
        private UserRepository userRepository;

        ProductServiceApplication (@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
                                   StudentRepository studentRepository, UserRepository userRepository){
            this.mentorRepository = mentorRepository;
            this.studentRepository = studentRepository;
            this.userRepository = userRepository;
        }*/
/*
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
*/

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
        System.out.println("Hello World");
    }


    @Override
    @Transactional
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
		/*Mentor mentor = new Mentor();
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
		userRepository.save(user);*/

       /* Category category = new Category();
        category.setName("Apple Device");
        Category savedCategory = categoryRepository.save(category);*/
       /* Optional<Category> OptionalCategory =  categoryRepository.findById(UUID.fromString("da3cdb28-99d0-4dce-9766-a6188da27d94"));
        if(OptionalCategory.isEmpty()){
            throw  new Exception("Category was null");
        }
        Category category = OptionalCategory.get();
        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("Best iPhone ever");
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);*/

        //Find all devices  with category - Apple devices
     /*   List<Product> products = category.getProducts();
        for(Product p : products){
            System.out.println(p.getTitle());
        }*/
/*        Price price = new Price();
        price.setCurrency("INR");
        price.setValue(100000);
        //Price savedPrice =  priceRepository.save(price);


        Category category = new Category();
        category.setName("Apple Device");
        Category savedCategory = categoryRepository.save(category);


        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("Best iPhone ever");
        product.setCategory(savedCategory);
        product.setPrice(price);
        Product savedProduct = productRepository.save(product);*/
        //priceRepository.deleteById(UUID.fromString("3848bf42-a6da-4ac0-98a0-0580288be7dd"));

        //productRepository.delete(savedProduct);

       // productRepository.deleteById(UUID.fromString("37bb3f65-139c-46bd-a970-602e32570322"));

/*
        Category category = new Category();
        category.setName("Apple Device");
        Category savedCategory = categoryRepository.save(category);

        Price price = new Price();
        price.setValue(100000);
        price.setCurrency("INR");
*/



/*        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("1e1b8ced-46a8-404c-a148-2d71445b03ff"));
        Category category = optionalCategory.get();

        List<Product> products = category.getProducts();
        for (Product product : products) {
            System.out.println(product.getTitle());
        }*/

        //select * from products
        List<Product> products = productRepository.findAllByTitleAndDescription("iPhone 15 pro max", "Best iPhone ever.");

        List<Product> products1 = productRepository.findAllByPrice_ValueLessThan(50000);
        List<Product> products2 = productRepository.findAllByPrice_ValueBetween(29000, 50000);
    }
}
