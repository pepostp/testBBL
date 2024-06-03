package com.example.demo.controller;

import com.example.demo.entity.Posts;
import com.example.demo.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("")
    public List<Posts> findAllPost() {
        return postsService.findAllPost();
    }

    @GetMapping("/{id}")
    public Optional<Posts> findPostById(@PathVariable Integer id) {
        return postsService.findPostById(id);
    }

    @PostMapping("")
    public ResponseEntity<Posts> savePost(@RequestBody Posts post) {
        Posts newPost = postsService.savePost(post);
        return ResponseEntity.ok(newPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer id) {
        postsService.deletePostById(id);
        return ResponseEntity.ok("Post id : "+id+" deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePostById(@PathVariable Integer id, @RequestBody Posts post) {
        Posts updatePost = postsService.updatePost(id, post);
        return ResponseEntity.ok(updatePost);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Posts> patchPostById(@PathVariable Integer id, @RequestBody Posts post) {
        Posts patchPost = postsService.patchPost(id, post);
        return ResponseEntity.ok(patchPost);
    }

    @GetMapping("/userid/{userid}")
    public List<Posts> findByUserId(@PathVariable Integer userid) {
        return postsService.findByUserId(userid);
    }
}
