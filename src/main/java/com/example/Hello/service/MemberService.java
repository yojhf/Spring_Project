package com.example.Hello.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.Hello.dto.Member;
import com.example.Hello.repo.MemberRepository;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService
{

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {

        Member member = memberRepository.findByEmail(email);

        if (member == null) throw new UsernameNotFoundException("Not Found account.");

        return member;
    }
}