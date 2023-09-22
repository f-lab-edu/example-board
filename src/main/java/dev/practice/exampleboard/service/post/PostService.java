package dev.practice.exampleboard.service.post;

import dev.practice.exampleboard.domain.post.Post;

public interface PostService {
    PostInfo.Main createPost(Post post);
    PostInfo.Main updatePost(Long postId, Post post);
    String deletePost(Long postId, String password);
    PostInfo.Main getPost(Long postId);
    PostInfo.PostGroupInfo getPosts(int limit, int offset);
}
