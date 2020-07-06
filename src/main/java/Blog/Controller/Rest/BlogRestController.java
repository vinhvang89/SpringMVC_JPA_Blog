package Blog.Controller.Rest;


import Blog.Model.Blog;
import Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @PutMapping("/{id}/likes")
    public Blog addLikeToBlog(@PathVariable("id") Long id){
        return blogService.addLike(id);

    }
}
