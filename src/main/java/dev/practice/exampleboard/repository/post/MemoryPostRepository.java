package dev.practice.exampleboard.repository.post;

import dev.practice.exampleboard.domain.post.Post;
import dev.practice.exampleboard.service.post.PostInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemoryPostRepository implements PostRepository {
    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Post createPost(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    @Override
    public Post updatePost(Long postId, Post post) {
        post.setId(postId);
        store.put(postId, post);
        return post;
    }

    @Override
    public String deletePost(Long id, String password) {
        Post post = store.get(id);
        if (post == null) throw new RuntimeException("invalid id");
        store.remove(id);
        return "삭제가 완료되었습니다.";
    }

    @Override
    public Post getPostById(Long id) {
        return store.get(id);
    }

    @Override
    public PostInfo.PostGroupInfo getPosts(int limit, int offset) {
        var postList = store.values().stream()
                .map(PostInfo.Main::new)
                .collect(Collectors.toList());

        return new PostInfo.PostGroupInfo(limit, offset, postList);
    }
}
