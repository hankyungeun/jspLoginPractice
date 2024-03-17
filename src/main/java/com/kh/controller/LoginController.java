package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kh.service.MemberService;
import com.kh.vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");

        Member loginUser = new MemberService().loginMember(userId,userPwd);


        if(loginUser == null) {
            request.setAttribute("errorMsg", "로그인에 실패했습니다.");

            RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
            // request, response 객체 포워딩
            view.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",loginUser);

            response.sendRedirect(request.getContextPath());
        }


    }

}
