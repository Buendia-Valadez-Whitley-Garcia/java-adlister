package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty() || email.isEmpty() || password.isEmpty();

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        //create values that will determine if a user can create an account with certain details
        boolean userNameExists = true;
        boolean userEmailExists = true;
        boolean passwordsDontMatch = true;

        //test to see if those account details have already been taken
        User userNameTest = DaoFactory.getUsersDao().findByUsername(username);
        User userEmailTest = DaoFactory.getUsersDao().findByUserEmail(email);


        if(userNameTest == null){
            userNameExists = false;
        }
        if(userEmailTest == null){
            userEmailExists = false;
        }
        if(password.equals(passwordConfirmation)){
            passwordsDontMatch = false;
        }

        String usernameFound = "<span style=\"color:red\">* already exists<span>";
        String emailFound = "<span style=\"color:red\">* already exists<span>";
        String passwordConflict = "<span style=\"color:red\">* Doesn't match<span>";

        // create and save a new user
        if(!userEmailExists && !userNameExists && !passwordsDontMatch){
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }else if(userEmailExists && userNameExists && passwordsDontMatch){
            request.setAttribute("usernameExists", usernameFound);
            request.setAttribute("emailExists", emailFound);
            request.setAttribute("passwordConflict", passwordConflict);
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
        }else if(userEmailExists || userNameExists){
            if(userEmailExists){
                request.setAttribute("emailExists", emailFound);
                request.setAttribute("usernameAttempt", username);
            }else{
                request.setAttribute("usernameExists", usernameFound);
                request.setAttribute("emailAttempt", email);
            }
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
        }else if(passwordsDontMatch){
            request.setAttribute("passwordConflict", passwordConflict);
            request.setAttribute("usernameAttempt", username);
            request.setAttribute("emailAttempt", email);
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
        }
    }
}
