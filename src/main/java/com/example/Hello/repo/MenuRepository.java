package com.example.Hello.repo;
import java.util.List;
import com.example.Hello.vo.MenuVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<MenuVo, Long>
{
//    @Query("SELECT  FROM tb_menu")
//    List<MenuVo> findAll();
}
