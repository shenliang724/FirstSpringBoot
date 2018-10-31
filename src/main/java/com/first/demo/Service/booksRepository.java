package com.first.demo.Service;

import com.first.demo.Model.book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface booksRepository extends MongoRepository<book,Long> {


}
