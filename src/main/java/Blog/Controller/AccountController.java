package Blog.Controller;

import Blog.Model.Account;
import Blog.Model.Role;
import Blog.Service.AccountService;
import Blog.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute("roles")
    public List<Role> roleList(){
        return roleService.findAll();
    }
    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("/accounts/list");
        mv.addObject("accounts",accountService.findAll());
        return mv;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Account account = accountService.findOne(id);
        ModelAndView mv = new ModelAndView("/accounts/edit");
        mv.addObject("account",account);
        return mv;
    }
    @PostMapping("/edit")
    public ModelAndView editAccount(@ModelAttribute("account") Account account){
        accountService.save(account);
        ModelAndView mv = new ModelAndView("/accounts/edit");
        mv.addObject("account",new Account());
        mv.addObject("roles",roleService.findAll());
        mv.addObject("message","Edition is successful");
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("/accounts/register");
        mv.addObject("account",new Account());
        return mv;
    }
    @PostMapping("/create-account")
    public ModelAndView createAccount(@ModelAttribute("account") Account account){
        account.setRole(roleService.findOne(2L));
        accountService.save(account);
        ModelAndView mv = new ModelAndView("/accounts/register");
        mv.addObject("account",account);
        mv.addObject("message","Creation is successful");
        return mv;
    }
}
