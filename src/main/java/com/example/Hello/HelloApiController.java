package com.example.Hello;

import com.example.Hello.dto.TbMusic;
import com.example.Hello.service.MenuService;
import com.example.Hello.service.MusicService;
import com.example.Hello.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloApiController
{
    @Autowired
    private MenuService menuService;
    @Autowired
    private MusicService musicService;
    @RequestMapping("/Hello")
    String home()
    {
        return "Hello World!";
    }
    @RequestMapping("/Helloko")
    String hello()
    {
        return "헬로우 월드";
    }

//    @PostMapping("/insert")
//    public ResponseEntity<MenuVo> save(MenuVo menu)
//    {
//        return new ResponseEntity<MenuVo>(menuService.save(menu), HttpStatus.OK);
//    }
    @GetMapping("/menulist")
    public ResponseEntity<List<MenuVo>> getAllMenu()
    {
        List<MenuVo> list = menuService.findAll();
        return new ResponseEntity<List<MenuVo>>(list, HttpStatus.OK);
    }
    @GetMapping("/api/v1/bestmenu")
    public ResponseEntity<List<MenuVo>> getRandMenu()
    {
        List<MenuVo> list = menuService.findRandMenu();
        return new ResponseEntity<List<MenuVo>>(list, HttpStatus.OK);
    }
    @PostMapping("/api/v1/insert")
    public Long save(@RequestBody MenuVo menuvo)
    {
        return menuService.save(menuvo);
    }
    @GetMapping("/api/v1/blogmenu")
    public ResponseEntity<String> getBestMenu(@RequestParam String keyword)
    {
        String json = menuService.blogSearch(keyword);
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
    @GetMapping("/api/v1/melon")
    public ResponseEntity<List<TbMusic>> getMelonList()
    {
        List<TbMusic> list = musicService.getMelonMusicList();
        return new ResponseEntity<List<TbMusic>>(list, HttpStatus.OK);
    }


}
