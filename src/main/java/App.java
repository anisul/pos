import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonDao;
import model.Person;

/**
 * Standalone application with Spring Data JPA, Hibernate and Maven
 *
 * @author Anisul Islam
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        PersonDao dao = context.getBean(PersonDao.class);

        Person person1 = new Person("Anisul", "Islam");
        Person person2 = new Person("Mehrose", "Islam");

        // Add new Person records
        dao.save(person1);
        dao.save(person2);

        // Count Person records
        System.out.println("Count Person records: " + dao.count());

        // Print all records
        List<Person> persons = (List<Person>) dao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }

        // Find Person by surname
        System.out.println("Find by surname 'Sagan': "	+ dao.findBySurname("Sagan"));

        // Update Person
        person2.setFirstName("Sadia");
        person2.setLastName("Mehrose");
        dao.save(person2);

        System.out.println("Find by id 2: " + dao.findOne(2L));

        // Remove record from Person
        dao.delete(2L);

        // And finally count records
        System.out.println("Count Person records: " + dao.count());

        context.close();
    }
}
