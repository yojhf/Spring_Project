package com.example.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController
{
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

}
