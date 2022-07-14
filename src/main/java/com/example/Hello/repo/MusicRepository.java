package com.example.Hello.repo;

import com.example.Hello.vo.MenuVo;
import com.example.Hello.vo.MusicVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicRepository extends JpaRepository<MusicVo, Long>
{

}

