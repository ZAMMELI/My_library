package com.my_library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my_library.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}


