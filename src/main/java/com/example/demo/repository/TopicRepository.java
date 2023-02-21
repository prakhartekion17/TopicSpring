package com.example.demo.repository;

import com.example.demo.classes.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends MongoRepository<Topic,String> {//spring data jpa is a class which is going to implement it


}
