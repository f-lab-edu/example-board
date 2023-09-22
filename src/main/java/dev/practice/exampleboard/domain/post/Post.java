package dev.practice.exampleboard.domain.post;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Getter
@ToString
@NoArgsConstructor
public class Post {

    private Long id;
    private String author;
    private String password;
    private String title;
    private String content;
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        OPEN("공개"), HIDDEN("비공개");
        private final String description;
    }

    @Builder
    public Post(String author, String password, String title, String content) {
        if (StringUtils.isEmpty(author)) throw new RuntimeException("empty author");
        if (StringUtils.isEmpty(password)) throw new RuntimeException("empty password");
        if (StringUtils.isEmpty(title)) throw new RuntimeException("empty title");
        if (StringUtils.isEmpty(content)) throw new RuntimeException("empty content");

        this.author = author;
        this.password = password;
        this.title = title;
        this.content = content;
        this.status = Status.OPEN;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
