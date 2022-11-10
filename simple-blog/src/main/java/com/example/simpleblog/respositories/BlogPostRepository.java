package com.example.simpleblog.respositories;

import com.example.simpleblog.model.BlogPost;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlogPostRepository {

    @Autowired
    MongoBlogPostRepository mongoRepo;

    public Optional<BlogPost> getById(String id) {
        return mongoRepo.findById(id);
    }

    public BlogPost addBlogPost(BlogPost blogPost) {
        return mongoRepo.save(blogPost);
    }

    public List<BlogPost> getAll() {
        return mongoRepo.findAll();

    }

    public void updateBlogPost(BlogPost blogPost) {
        mongoRepo.save(blogPost);
    }


    public void deleteBlogPost(String id) {
        mongoRepo.deleteById(id);
    }
}
