package com.example.Hello.service;

import com.example.Hello.repo.MenuRepository;
import com.example.Hello.utiles.NaverApi;
import com.example.Hello.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService
{
    @Autowired
    private MenuRepository menuRepository;

    // 전체 데이터 조회
    public List<MenuVo> findAll()
    {
        List<MenuVo> menu = new ArrayList<>();
        menuRepository.findAll().forEach(e -> menu.add(e));
        return menu;
    }

    // 데이터 넣기(insert)
    public Long save(MenuVo menu)
    {
        return menuRepository.save(menu).getId();
    }
    public List<MenuVo> findRandMenu()
    {
        return menuRepository.findRandMenu();
    }
    public String blogSearch(String keyword)
    {
        return NaverApi.blogSearch(keyword);
    }

}
