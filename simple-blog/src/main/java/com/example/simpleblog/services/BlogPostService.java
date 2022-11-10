package com.example.simpleblog.services;
import com.example.simpleblog.model.BlogPost;
import com.example.simpleblog.respositories.BlogPostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepo;

    public BlogPost add(BlogPost blogPost) {
        if (blogPost.getId() == null) {
            blogPost.setPublishedAt(LocalDateTime.now());
        }
        return blogPostRepo.addBlogPost(blogPost);
    }

    public List<BlogPost> getAllPosts() {
        return blogPostRepo.getAll();
    }

    public Optional<BlogPost> getPostById(String id) {
        return blogPostRepo.getById(id);
    }

    public BlogPost updateBlogPost(BlogPost blogPost) {
        blogPostRepo.updateBlogPost(blogPost);
        return blogPost;
    }

    public void deleteBlogPost(String id) {
        blogPostRepo.deleteBlogPost(id);
    }
}
