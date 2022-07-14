package com.example.Hello.utiles;

// 네이버 검색 API 예제 - blog 검색
import com.example.Hello.dto.TbMusic;
import com.example.Hello.vo.MusicVo;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// static new를 안써도 바로 사용가능, 부하가 심해 자주 사용하는 것에 사용
public class MelonApi
{
    public static List<TbMusic> getMelonMusicList()
    {
        final String stockList  = "https://www.melon.com/chart/index.htm";
        Connection conn = Jsoup.connect(stockList);
        List<TbMusic> list = new ArrayList<>();

        try
        {
            Document document = conn.get();
//            String thead = getStockHeader(document); // 칼럼명
            Elements stockTableBody = document.select("div.wrap_song_info");
            List<String> songList = new ArrayList<>();
            int rank = 1;

            for (Element element : stockTableBody.select("div.ellipsis.rank01"))
            {
                String song = element.select("a").text();   // 노래 제목
                songList.add(song);
//                System.out.println((rank++) + ": " + song);
            }
            rank = 1;
            for (Element element : stockTableBody.select("span.checkEllipsis"))
            {
                String gasu = element.select("a").text();   // 노래 제목
                TbMusic dto = new TbMusic();
                dto.setSong(songList.get(rank-1));
                dto.setGasu(gasu);
                dto.setRank(rank++);
                list.add(dto);
//                System.out.println((rank++) + ": " + song);
            }
        }
        catch (IOException ignored)
        {

        }
        return list;
    }
}