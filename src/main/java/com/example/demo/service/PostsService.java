package com.example.demo.service;

import com.example.demo.entity.Posts;
import com.example.demo.repository.PostsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts savePost(Posts post) {
        return postsRepository.save(post);
    }

    public List<Posts> findAllPost() {
        return postsRepository.findAll();
    }

    public Optional<Posts> findPostById(Integer id) {
        return postsRepository.findById(id);
    }

    public void deletePostById(Integer id) {postsRepository.deleteById(id);}

    public Posts updatePost(Integer id, Posts updatedPost) {
        Optional<Posts> existingPost = postsRepository.findById(id);
        if (existingPost.isPresent()) {
            Posts post = existingPost.get();
            post.setUserId(updatedPost.getUserId());
            post.setTitle(updatedPost.getTitle());
            post.setBody(updatedPost.getBody());
            return postsRepository.save(post);
        } else {
            throw new RuntimeException("Post not found");
        }
    }

    public Posts patchPost(Integer id, Posts updatedPost) {
        //Update some field
        Optional<Posts> existingPost = postsRepository.findById(id);
        if (existingPost.isPresent()) {
            Posts post = existingPost.get();
            if(updatedPost.getUserId() != null){
                post.setUserId(updatedPost.getUserId());
            }
            if(StringUtils.isNotBlank(updatedPost.getTitle())){
                post.setTitle(updatedPost.getTitle());
            }
            if(StringUtils.isNotBlank(updatedPost.getBody())){
                post.setBody(updatedPost.getBody());
            }
            return postsRepository.save(post);
        } else {
            throw new RuntimeException("Post not found");
        }
    }

    public List<Posts> findByUserId(Integer userId) {
        return postsRepository.findByUserId(userId);
    }


}
