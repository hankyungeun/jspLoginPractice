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

        String userId = request.getParameter("id");
        String userPwd = request.getParameter("passwd");

        Member loginUser = new MemberService().loginMember(userId,userPwd);


        if(loginUser == null) {
            RequestDispatcher view = request.getRequestDispatcher("views/errorPage.jsp");
            view.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",loginUser);

            RequestDispatcher view = request.getRequestDispatcher("views/loginSuccess.jsp");
            view.forward(request, response);
        }


    }

}
