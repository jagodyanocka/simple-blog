package com.example.simpleblog.respositories;

import com.example.simpleblog.model.BlogPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBlogPostRepository extends MongoRepository<BlogPost, String> {

}
