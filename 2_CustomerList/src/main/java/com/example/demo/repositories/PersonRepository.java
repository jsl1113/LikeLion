package com.example.demo.repositories;

import com.example.demo.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "peo", path="people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>,
        CrudRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);

}
