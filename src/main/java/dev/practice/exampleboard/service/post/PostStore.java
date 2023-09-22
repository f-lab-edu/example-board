package dev.practice.exampleboard.service.post;

import dev.practice.exampleboard.domain.post.Post;

public interface PostStore {
    Post create(Post post);
    Post update(Long postId, Post post);
    String delete(Long postId, String password);
    Post getPostById(Long postId);
    PostInfo.PostGroupInfo getPosts(int limit, int offset);
}
