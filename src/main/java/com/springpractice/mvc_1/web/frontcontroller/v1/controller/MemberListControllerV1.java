package com.springpractice.mvc_1.web.frontcontroller.v1.controller;

import com.springpractice.mvc_1.domain.member.Member;
import com.springpractice.mvc_1.domain.member.MemberRepository;
import com.springpractice.mvc_1.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Member> list = memberRepository.findAll();
        request.setAttribute("list", list);

        String viewPath = "/WEB-INF/views/members.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

}
