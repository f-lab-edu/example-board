package dev.practice.exampleboard.controller.post;

import dev.practice.exampleboard.domain.post.Post;
import dev.practice.exampleboard.service.post.PostInfo;
import dev.practice.exampleboard.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;

    public PostInfo.Main createPost(Post post) {
        return postService.createPost(post);
    }

    public PostInfo.Main updatePost(Long postId, Post post) {
        return postService.updatePost(postId, post);
    }

    public String deletePost(Long id, String password) {
        return postService.deletePost(id, password);
    }

    public PostInfo.Main getPostById(Long id) {
        return postService.getPost(id);
    }

    public PostInfo.PostGroupInfo getPosts(int limit, int offset) {
        return postService.getPosts(limit, offset);
    }
}
