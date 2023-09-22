package dev.practice.exampleboard.service.post;

import dev.practice.exampleboard.domain.post.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostStore postStore;

    @Override
    public PostInfo.Main createPost(Post initPost) {
        Post post = postStore.create(initPost);

        return new PostInfo.Main(post);
    }

    @Override
    public PostInfo.Main updatePost(Long postId, Post editPost) {
        Post post = postStore.update(postId, editPost);

        return new PostInfo.Main(post);
    }

    @Override
    public String deletePost(Long postId, String password) {
        postStore.delete(postId, password);

        return "게시글이 삭제되었습니다.";
    }

    @Override
    public PostInfo.Main getPost(Long postId) {
        var post = postStore.getPostById(postId);

        return new PostInfo.Main(post);
    }

    @Override
    public PostInfo.PostGroupInfo getPosts(int limit, int offset) {
        return postStore.getPosts(limit, offset);
    }
}
