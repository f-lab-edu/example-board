package dev.practice.exampleboard.controller.post;

import dev.practice.exampleboard.domain.post.Post;
import dev.practice.exampleboard.service.post.PostInfo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/posts")
public class PostApiController {
    private final PostFacade postFacade;

    @GetMapping
    public String posts(Model model) {
        PostInfo.PostGroupInfo posts = postFacade.getPosts(0, 0);
        model.addAttribute("posts", posts);

        return "basic/posts";
    }

    @GetMapping("{postId}")
    public String post(@PathVariable Long postId, Model model) {
        PostInfo.Main post = postFacade.getPostById(postId);
        model.addAttribute("post", post);

        return "basic/post";
    }

    @GetMapping("/create")
    public String createForm() {
        return "basic/createForm";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String author,
                             @RequestParam String password,
                             @RequestParam String title,
                             @RequestParam String content,
                             RedirectAttributes redirectAttributes) {
        Post initPost = new Post(author, password, title, content);
        PostInfo.Main post = postFacade.createPost(initPost);

        redirectAttributes.addAttribute("postId", post.getId());

        return "redirect:/basic/posts/{postId}";
    }

    @GetMapping("/{postId}/update")
    public String updatePost(@PathVariable Long postId, Model model) {
        PostInfo.Main post = postFacade.getPostById(postId);
        model.addAttribute("post", post);
        return "basic/updateForm";
    }

    @PostMapping("/{postId}/update")
    public String updatePost(@PathVariable Long postId,
                             @RequestParam String author,
                             @RequestParam String password,
                             @RequestParam String title,
                             @RequestParam String content) {
        Post post = new Post(author, password, title, content);
        System.out.println(postId);
        System.out.println(author);
        postFacade.updatePost(postId, post);

        return "redirect:/basic/posts/{postId}";
    }

    @DeleteMapping("/{postId}/delete")
    public String deletePost(@PathVariable Long postId, @ModelAttribute String password) {
        postFacade.deletePost(postId, password);

        return "redirect:/basic/posts";
    }

    @PostConstruct
    public void init() {
        postFacade.createPost(new Post("김작가", "1", "제목1", "내용1"));
        postFacade.createPost(new Post("이작가", "2", "제목2", "내용2"));
    }
}
