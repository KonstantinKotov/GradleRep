package servletshibernate;

import daohibernate.*;
import entity.*;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.*;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import springdao.*;

import javax.persistence.Access;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {

    @Autowired
    AccessInt accessSpringDao;
    @Autowired
    UserInt userSpringDao;
    @Autowired
    MaterialInt materialSpringDao;
    @Autowired
    ListOfTopInt listOfTopicsSpringDao;
    @Autowired
    SectionInt sectionSpringDao;
    @Autowired
    TopicInt topicSpringDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext( this,
                config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequests(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequests(request, response);
    }

    public void pageTopics(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = makeParamID(request, response, "topID");
        HttpSession session = request.getSession();
        try {

            List<ListoftopicsinmaterialEntity> listOfTopics =
                    (List<ListoftopicsinmaterialEntity>) session.getAttribute("listOfTop");
            TopicsEntity topic = topicSpringDao.read(listOfTopics.get(id));
            List<SectionsEntity> listSections = sectionSpringDao.read(topic);
            session.setAttribute("listOfSections", listSections);
            UsersEntity user = (UsersEntity) session.getAttribute("user");

            request.setAttribute("user", user.getUserFirstName() + " " + user.getUserSecondName());
            request.setAttribute("topic_name", topic.getTopicName());
            request.setAttribute("topic_description", topic.getTopicDescription());
            for (int i = 0; i < listSections.size(); i++) {
                request.setAttribute("section_name" + i, listSections.get(i).getSectionName());
            }
            getServletContext().getRequestDispatcher("/page3.jsp").forward(request, response);
        } catch (HibernateException e) {
            request.setAttribute("error", "Sorry, we have a problem with DB and we are working on it."+
                    e.getClass()+ e.getStackTrace()+ e.getMessage());
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    public void pageSections(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = makeParamID(request, response, "sectionID");
        HttpSession session = request.getSession();

        try {
            List<SectionsEntity> listOfSections =
                    (List<SectionsEntity>) session.getAttribute("listOfSections");
            SectionsEntity section = listOfSections.get(id);
            UsersEntity user = (UsersEntity) session.getAttribute("user");
            request.setAttribute("user", user.getUserFirstName() + " " + user.getUserSecondName());
            request.setAttribute("section_name", section.getSectionName());
            request.setAttribute("section_content", section.getSectionContent());
            for (int i = 0; i < listOfSections.size(); i++) {
                request.setAttribute("section_name" + i, listOfSections.get(i).getSectionName());
            }
            getServletContext().getRequestDispatcher("/page4.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it. Exception");
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    public void pageAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = makeParamID(request, response, "id");
        HttpSession session = request.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/html; charset=utf-8");

        try {
            List<SectionsEntity> listOfSections =
                    (List<SectionsEntity>) session.getAttribute("listOfSections");
            SectionsEntity section = listOfSections.get(id);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            String content = section.getSectionContent();
            response.getWriter().write(content);



        } catch (Exception e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it. Exception");
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ListoftopicsinmaterialEntity> listOfTopics =
                (List<ListoftopicsinmaterialEntity>) session.getAttribute("listOfTop");
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        request.setAttribute("user", user.getUserFirstName() + " " + user.getUserSecondName());
        for (int i = 0; i < listOfTopics.size(); i++) {
            request.setAttribute("topic" + i, listOfTopics.get(i).getTopicsByListTopicId().getTopicName());
        }
        getServletContext().getRequestDispatcher("/page2.jsp").forward(request, response);
    }

    public void signInPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        try {
            //ManageAccess manageAccess = (ManageAccess) session.getAttribute("manageAccess");
            //ManageUser manageUser = (ManageUser) session.getAttribute("manageUser");
            //ManageMaterial manageMaterial = (ManageMaterial) session.getAttribute("manageMaterial");
            //ManageListOfTopics manageListOfTopics = (ManageListOfTopics) session.getAttribute("manageListOfTopics");

            if (login.isEmpty()) {
                request.setAttribute("message", "Fill in login field");
            } else {
                UsersAccessEntity access = accessSpringDao.read(login);
                if (login.equals(access.getAccessLogin()) && password.equals(access.getAccessPassword())) {
                    UsersEntity user = userSpringDao.read(access);

                    session.setAttribute("user", user);
                    MaterialsEntity material = materialSpringDao.read(user);
                    List<ListoftopicsinmaterialEntity> listOfTopicsInInfoMaterial = listOfTopicsSpringDao.read(material);
                    session.setAttribute("listOfTop", listOfTopicsInInfoMaterial);

                    request.setAttribute("user", user.getUserFirstName() + " " + user.getUserSecondName());
                    for (int i = 0; i < listOfTopicsInInfoMaterial.size(); i++) {
                        request.setAttribute("topic" + i, listOfTopicsInInfoMaterial.get(i).getTopicsByListTopicId().getTopicName());
                    }
                    getServletContext().getRequestDispatcher("/page2.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Incorrect login or password");
                }
            }
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (HibernateException e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it" +
                    e.getClass()+ e.getStackTrace());
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
             } catch (Throwable e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it. ExceptionT"+
                    e.getClass()+ e.getStackTrace().toString() + e.getLocalizedMessage() + e.getCause());
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    public void handleRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("pageManagerID");

        try {

            switch (page) {
                case "signIn":
                    signInPage(request, response);
                    break;
                case "topics":
                    pageTopics(request, response);
                    break;
                case "sections":
                    pageSections(request, response);
                    break;
                case "home":
                    home(request, response);
                    break;
                //case "signOut":
                    //signOut(request, response);
                    //break;
                case "profile":
                    profile(request, response);
                    break;
                case "ajax":
                    pageAjax(request, response);
                    break;
            }
        } catch (Throwable t) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it.dispatcher");
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    public int makeParamID(HttpServletRequest request, HttpServletResponse response, String param) throws ServletException, IOException {
        String req = request.getParameter(param);
        Integer page = Integer.parseInt(req);
        return page;
    }

   /* public  void signOut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Throwable t = null;
        HttpSession session = request.getSession();
        TopicDao topicDao = (TopicDao) session.getAttribute("topicDao");
        SectionDao sectionDao = (SectionDao) session.getAttribute("sectionDao");
        MySqlAccessDao accessDao = (MySqlAccessDao) session.getAttribute("accessDao");
        MySqlUserDao userDao = (MySqlUserDao) session.getAttribute("userDao");
        MySqlListOfTopicsDao listOfTopicsDao = (MySqlListOfTopicsDao) session.getAttribute("listOfTopicsDao");
        MySqlMaterialDao materialDao = (MySqlMaterialDao) session.getAttribute("materialDao");
        try {
            accessDao.close();
        } catch (DAOException e) {
            t = new DAOException();
            request.setAttribute("error", "Problem with resources closing");
        }
        try {
            userDao.close();
        } catch (DAOException e) {
            t = new DAOException();
            request.setAttribute("error", "Problem with resources closing");
        }
        try {
            materialDao.close();
        } catch (DAOException e) {
            t = new DAOException();
            request.setAttribute("error", "Problem with resources closing");
        }
        try {
            listOfTopicsDao.close();
        } catch (DAOException e) {
            t = new DAOException();
            request.setAttribute("error", "Problem with resources closing");
        }
        try {
           topicDao.close();
        } catch (DAOException e) {
            request.setAttribute("error", "Problem with resources closing");
            t = new DAOException();
        }
        try {
            sectionDao.close();
        } catch (DAOException e) {
            request.setAttribute("error", "Problem with resources closing");
            t = new DAOException();
        }
        if (t != null){
            getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
        session.invalidate();
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }*/

    public  void profile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        List<ListoftopicsinmaterialEntity> listOfTopicsInInfoMaterial =
                (List<ListoftopicsinmaterialEntity>) session.getAttribute("listOfTop");

        request.setAttribute("userName", user.getUserFirstName() + " " + user.getUserSecondName());
        request.setAttribute("firstName", user.getUserFirstName());
        request.setAttribute("secondName", user.getUserSecondName());
        request.setAttribute("midName", user.getUserMidName());
        request.setAttribute("sex", user.getUserSex());
        request.setAttribute("birthDate", user.getUserBirthDate());
        request.setAttribute("workStartDate", user.getUserWorkFromDate());
        request.setAttribute("department", user.getUserDepartment());
        request.setAttribute("position", user.getUserPosition());

        for (int i = 0; i < listOfTopicsInInfoMaterial.size(); i++) {
            request.setAttribute("topic" + i, listOfTopicsInInfoMaterial.get(i).getTopicsByListTopicId().getTopicName());
        }

        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}

