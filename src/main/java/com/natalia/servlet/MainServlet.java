package com.natalia.servlet;

import com.natalia.controller.Controller;
import com.natalia.factory.Factory;
import com.natalia.view.ViewModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.natalia.factory.Factory.*;

public class MainServlet extends HttpServlet {

    private final Map<Request, Controller> controllerMap = new HashMap<>();

    public void init() throws ServletException {
        controllerMap.put(Request.create("GET", "/root/home"), Factory.getHomeController());
        controllerMap.put(Request.create("GET", "/root/signUp"), Factory.getSignUpController());
        controllerMap.put(Request.create("GET", "/error"), Factory.getErrorController());
        controllerMap.put(Request.create("POST", "/root/signUp"), Factory.getRegistrationController(
                getUserServiceImpl(
                        getUserDaoImpl(
                                getConnection()))));
        controllerMap.put(Request.create("GET", "/root/users"), Factory.getAllUsersController(
                getUserServiceImpl(
                        getUserDaoImpl(
                                getConnection()))));
        controllerMap.put(Request.create("GET", "/root/users/remove"), Factory.getRemoveController(
                getUserServiceImpl(
                        getUserDaoImpl(
                                getConnection()))));
        controllerMap.put(Request.create("GET", "/root/user"), Factory.getUserGetByIdController(
                getUserServiceImpl(
                        getUserDaoImpl(
                                getConnection()))));
        controllerMap.put(Request.create("GET", "/root/userform"), Factory.getUserFormController());
        controllerMap.put(Request.create("POST", "/root/userform"), Factory.getUpdateController(
                getUserServiceImpl(
                        getUserDaoImpl(
                                getConnection()))));
        controllerMap.put(Request.create("GET", "/root/categories"), Factory.getAllCategoriesController(
                getCategoryServiceImpl(
                        getCategoryDaoImpl(
                                getConnection()))));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = getUri(request.getRequestURI());
        Request req = new Request(request.getMethod(), uri, request.getParameterMap());
        try {
            Controller controller = controllerMap.get(req);
            if (controller == null) {
                throw new RuntimeException("Cannot handle " + req);
            }
            ViewModel viewModel = controller.process(req);
            if (viewModel.hasCookies()) {
                Map<String, String> newCookies = viewModel.getNewCookies();
                for (String cookieName : newCookies.keySet()) {
                    response.addCookie(new Cookie(cookieName, newCookies.get(cookieName)));
                }
            }
            forward(request, response, viewModel);
        } catch (Throwable t) {
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    private String getUri(String requestURI) {
        if (!requestURI.contains("?")) {
            return requestURI;
        }
        return requestURI.substring(0, requestURI.indexOf("?"));
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, ViewModel viewModel) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(getView(request, viewModel));
        setAttributes(request, viewModel);
        dispatcher.forward(request, response);
    }

    private void setAttributes(HttpServletRequest request, ViewModel viewModel) {
        for (String attr : viewModel.getAttributes().keySet()) {
            request.setAttribute(attr, viewModel.getAttribute(attr));
        }
    }

    private String getView(HttpServletRequest request, ViewModel viewModel) {
        return request.getContextPath() + viewModel.getView();
    }
}