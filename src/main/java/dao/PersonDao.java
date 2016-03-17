package dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Person;

/**
 * Person dao interface
 *
 * @author Anisul Islam
 */
@Repository
public interface PersonDao extends CrudRepository<Person, Long> {

    public List<Person> findBySurname(String surname);
}