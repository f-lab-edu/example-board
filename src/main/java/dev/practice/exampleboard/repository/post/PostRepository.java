package dev.practice.exampleboard.repository.post;

import dev.practice.exampleboard.domain.post.Post;
import dev.practice.exampleboard.service.post.PostInfo;

public interface PostRepository {
    Post createPost(Post post);
    Post updatePost(Long postId, Post post);
    String deletePost(Long postId, String password);
    Post getPostById(Long postId);
    PostInfo.PostGroupInfo getPosts(int limit, int offset);
}
