package com.example.simpleblog.controller;
import com.example.simpleblog.model.BlogPost;
import com.example.simpleblog.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class BlogPostController {

    final
    BlogPostService service;

    @Autowired
    public BlogPostController(BlogPostService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<BlogPost> createNewPost(@RequestBody BlogPost blogPost) {
        BlogPost newBlogPost = service.add(blogPost);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json");
        header.add("Location", "/api");
        ResponseEntity<BlogPost> responseEntity = new ResponseEntity<>(newBlogPost, header, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/all")
    ResponseEntity<List<BlogPost>> listAllBlogPosts() {
        List<BlogPost> blogPostList = service.getAllPosts();
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json");
        header.add("Location", "/api/all");
        ResponseEntity<List<BlogPost>> responseEntity = new ResponseEntity<>(blogPostList, header, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{id}")
    ResponseEntity<BlogPost> getPostById(@PathVariable String id) {
        Optional<BlogPost> blogPost = service.getPostById(id);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/" + id);

        if (blogPost.isPresent()) {
            return new ResponseEntity<>(blogPost.get(), header, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<BlogPost> editBlogPost(@PathVariable String id, @RequestBody BlogPost blogPost) {
        if (!Objects.equals(id, blogPost.getId()) || id == null || blogPost.getId() ==  null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<BlogPost> existingBlogPost = service.getPostById(id);
        if ( !existingBlogPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/all/" + id);
        BlogPost editedBlogPost = service.updateBlogPost(blogPost);
        return new ResponseEntity<>(editedBlogPost, header, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<BlogPost> deletePostById(@PathVariable String id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<BlogPost> existingBlogPost = service.getPostById(id);
        if ( !existingBlogPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }
}
