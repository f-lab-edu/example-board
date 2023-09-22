package dev.practice.exampleboard.repository.post;

import dev.practice.exampleboard.domain.post.Post;
import dev.practice.exampleboard.service.post.PostInfo;
import dev.practice.exampleboard.service.post.PostStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostStoreImpl implements PostStore {
    private final PostRepository postRepository;

    @Override
    public Post create(Post post) {
        if (StringUtils.isEmpty(post.getAuthor())) throw new RuntimeException("empty author");
        if (StringUtils.isEmpty(post.getPassword())) throw new RuntimeException("empty password");
        if (StringUtils.isEmpty(post.getTitle())) throw new RuntimeException("empty title");
        if (StringUtils.isEmpty(post.getContent())) throw new RuntimeException("empty content");

        return postRepository.createPost(post);
    }

    @Override
    public Post update(Long postId, Post post) {
        if (postId == null) throw new RuntimeException("empty id");
        if (StringUtils.isEmpty(post.getAuthor())) throw new RuntimeException("empty author");
        if (StringUtils.isEmpty(post.getPassword())) throw new RuntimeException("empty password");
        if (StringUtils.isEmpty(post.getTitle())) throw new RuntimeException("empty title");
        if (StringUtils.isEmpty(post.getContent())) throw new RuntimeException("empty content");

        return postRepository.updatePost(postId, post);
    }

    @Override
    public String delete(Long id, String password) {
        if (id == null) throw new RuntimeException("empty id");
        if (StringUtils.isEmpty(password)) throw new RuntimeException("empty password");

        return postRepository.deletePost(id, password);
    }

    @Override
    public Post getPostById(Long postId) {
        if (postId == null) throw new RuntimeException("empty id");

        return postRepository.getPostById(postId);
    }

    @Override
    public PostInfo.PostGroupInfo getPosts(int limit, int offset) {
        return postRepository.getPosts(limit, offset);
    }
}
