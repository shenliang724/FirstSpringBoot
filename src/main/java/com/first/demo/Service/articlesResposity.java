package com.first.demo.Service;


import com.first.demo.Model.bookarticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface articlesResposity extends MongoRepository<bookarticle,Integer> {




}
