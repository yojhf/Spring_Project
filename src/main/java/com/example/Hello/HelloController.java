package com.example.Hello;

import com.example.Hello.dto.TbMenu;
import com.example.Hello.dto.TbUser;
import com.example.Hello.service.MenuService;
import com.example.Hello.service.MusicService;
import com.example.Hello.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController
{
    @Autowired
    private MenuService menuService;
    @Autowired
    private MusicService musicService;
    @GetMapping("/")
    public String index()
    {
        return "index";
    }
    @GetMapping("/blog")
    public String blog()
    {
        return "blog";
    }
    @GetMapping("/insert")
    public String insert()
    {
        return "insert";
    }
    @PostMapping("/insert_proc")
    @ResponseBody
    public TbMenu insert_proc(@ModelAttribute TbMenu tbmenu)
    {
        System.out.println(tbmenu.getMenu());
        System.out.println(tbmenu.getPrice());
        System.out.println(tbmenu.getImg());
        return tbmenu;
    }
    @GetMapping("/see")
    public String see(Model model)
    {
        model.addAttribute("list", menuService.findAll());
        return "see";
    }
    @GetMapping("/melon")
    public String melon(Model model)
    {
        model.addAttribute("list", musicService.getMelonMusicList());
        return "melon";
    }
    @GetMapping("/best")
    public String best()
    {
        return "best";
    }





    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @PostMapping("/aaa")
    @ResponseBody
    public String aaa(@ModelAttribute TbUser tbuser)
    {
        System.out.println(tbuser.getUserid());
        System.out.println(tbuser.getUserpw());
        System.out.println(tbuser.getName());
        System.out.println(tbuser.getRedate());
        return "????????? ??????";
    }


}
