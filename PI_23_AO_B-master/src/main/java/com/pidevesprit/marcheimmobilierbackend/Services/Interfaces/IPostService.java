package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAllPost();

    Post getPost(Long postId);

    Post addPost(Post post);

    void deletePost(Long postId);

    Post updatePost(Post post);

}
