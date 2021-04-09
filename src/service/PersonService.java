package service;

import entity.Person;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class PersonService {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person)
    {
        //Person person = new Person().setName("A").setFamily("B");
        entityManager.persist(person);
    }
}
