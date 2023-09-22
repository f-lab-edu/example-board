package dev.practice.exampleboard.service.post;

import dev.practice.exampleboard.domain.post.Post;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class PostInfo {

    @Getter
    @ToString
    public static class Main {
        private final Long id;
        private final String author;
        private final String title;
        private final String content;
        private final Post.Status status;

        public Main(Post post) {
            this.id = post.getId();
            this.author = post.getAuthor();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.status = post.getStatus();
        }
    }

    @Getter
    @ToString
    public static class PostGroupInfo {
        private final int limit;
        private final int offset;
        private final List<Main> postList;

        public PostGroupInfo(int limit, int offset, List<Main> postList) {
            this.limit = limit;
            this.offset = offset;
            this.postList = postList;
        }
    }
}
