package ru.vlasov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlasov.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
