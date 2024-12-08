package com.my_library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my_library.entities.Livres;

@Repository
public interface LivresRepository extends CrudRepository<Livres, Long>{

}
