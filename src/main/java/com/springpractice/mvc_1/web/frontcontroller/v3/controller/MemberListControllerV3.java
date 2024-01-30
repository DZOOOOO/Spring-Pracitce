package com.springpractice.mvc_1.web.frontcontroller.v3.controller;

import com.springpractice.mvc_1.domain.member.Member;
import com.springpractice.mvc_1.domain.member.MemberRepository;
import com.springpractice.mvc_1.web.frontcontroller.ModelView;
import com.springpractice.mvc_1.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }

}
