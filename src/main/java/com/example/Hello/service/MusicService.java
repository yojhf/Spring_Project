package com.example.Hello.service;

import com.example.Hello.dto.TbMusic;
import com.example.Hello.repo.MusicRepository;
import com.example.Hello.utiles.MelonApi;
import com.example.Hello.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService
{
    @Autowired
    private MusicRepository musicRepository;

    public List<MusicVo> findAll()
    {
        List<MusicVo> music = new ArrayList<>();
        musicRepository.findAll().forEach(e -> music.add(e));
        return music;
    }

    // 데이터 넣기(insert)
    public Long save(MusicVo music)
    {
        return musicRepository.save(music).getId();
    }

    // 멜론 차트를 크롤링 해서 리스트를 전달
    public List<TbMusic> getMelonMusicList()
    {
        return MelonApi.getMelonMusicList();
    }
}
