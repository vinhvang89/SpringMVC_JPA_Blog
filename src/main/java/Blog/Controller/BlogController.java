package Blog.Controller;



import Blog.Model.Blog;
import Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("blogs",blogService.findAll());
        return mv;
    }
    @GetMapping("/blog/{id}")
    public ModelAndView getBlogDetail(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("blog");
        mv.addObject("blog",blogService.findOne(id));
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("save");
        mv.addObject("blog",new Blog());
        return mv;
    }
    @GetMapping("/{id}/update")
    public ModelAndView showUpdateForm(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("save");
        mv.addObject("blog",blogService.findOne(id));
        return mv;
    }
    @PostMapping("/save-blog")
    public ModelAndView save(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView mv = new ModelAndView("save");
        mv.addObject("blog",new Blog());
        mv.addObject("message","Save is successful");
        return mv;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("delete");
        mv.addObject("blog",blogService.findOne(id));
        return mv;
    }
    @PostMapping("/delete-blog")
    public ModelAndView delete(@ModelAttribute ("blog") Blog blog){
        ModelAndView mv = new ModelAndView("delete");
        mv.addObject("blog",blogService.remove(blog.getId()));
        mv.addObject("message","Done !!!");
        return mv;
    }
}
