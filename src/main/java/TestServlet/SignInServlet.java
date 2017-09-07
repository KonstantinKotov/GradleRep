package TestServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      /*  String login = request.getParameter("login");
        String password = request.getParameter("password");
        MySqlDaoFactory daoFactory = new MySqlDaoFactory();
        MySqlAccessDao accessDao = null;
        MySqlUserDao userDao;
        MySqlMaterialDao materialDao;
        MySqlListOfTopicsDao listOfTopicsDao;
        Access access;
        User user;
        InfoMaterial material;
        List<ListOfTopicsInInfoMaterial> listOfTopicsInInfoMaterial;

        HttpSession session;


        try {
            accessDao = daoFactory.createAccessDao();
            userDao = daoFactory.createUserDao();
            listOfTopicsDao = daoFactory.createListOfTopicsDao();
            materialDao = daoFactory.createMaterialDao();

            if (login.isEmpty()){
                request.setAttribute("message","Fill in login field");
            }
            else {
                access = accessDao.read(login);
                if (login.equals(access.getLogin()) && password.equals(access.getPassword())){
                    user = userDao.read(access);
                    session = request.getSession();
                    session.setAttribute("user", user);
                    material = materialDao.read(user);
                    listOfTopicsInInfoMaterial = listOfTopicsDao.read(material);
                    session.setAttribute("listOfTop", listOfTopicsInInfoMaterial);


                    request.setAttribute("user", user.getFirstName()+" "+user.getSecondName());

                   for(int i=0; i<listOfTopicsInInfoMaterial.size(); i++){
                       request.setAttribute("topic"+i, listOfTopicsInInfoMaterial.get(i).getTopicName());
                    }
                    getServletContext().getRequestDispatcher("/page2.jsp").forward(request, response);
                } else {
                    request.setAttribute("message","Incorrect login or password");
                }
            }
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it");
        } catch (Throwable e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it. ExceptionT");
        } finally {
            try {
                accessDao.close();
            } catch (DAOException e) {
                request.setAttribute("error","Problem with resources closing");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("topID");
        Integer id = Integer.parseInt(sid);
        String sidSection = request.getParameter("sectionID");
        Integer idSection = Integer.parseInt(sidSection);
        if(idSection<100){
            id = idSection;
        }
        Topic topic;
        TopicDao topicDao = null;
        List <Section> listSections;
        SectionDao sectionDao = null;
        MySqlDaoFactory daoFactory = new MySqlDaoFactory();

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<ListOfTopicsInInfoMaterial> listOfTopics =
                    (List<ListOfTopicsInInfoMaterial>) session.getAttribute("listOfTop");
            topicDao = daoFactory.createTopicDao();
            sectionDao = daoFactory.createSectionDao();
            topic = topicDao.read(listOfTopics.get(id));
            listSections = sectionDao.read(topic);
            session.setAttribute("listOfSections", listSections);

            request.setAttribute("user", user.getFirstName() +" "+ user.getSecondName());
            request.setAttribute("topic_name", topic.getTopicName());
            request.setAttribute("topic_description", topic.getTopicDescription());
            for(int i=0; i<listSections.size(); i++){
                request.setAttribute("section_name"+i, listSections.get(i).getSectionName());
            }
            if(idSection>=1000){
                getServletContext().getRequestDispatcher("/page3.jsp").forward(request, response);
            }
            request.setAttribute("section_name", listSections.get(id).getSectionName());
            request.setAttribute("section_content", listSections.get(id).getSectionContext());

            if( idSection>=100 && idSection < 1000){
                getServletContext().getRequestDispatcher("/page3.jsp").forward(request, response);
            }else{
                getServletContext().getRequestDispatcher("/page4.jsp").forward(request, response);
            }
        } catch (DAOException e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it");
        } catch (Exception e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it. Exception");
        }finally {
            try {
                sectionDao.close();
            } catch (DAOException e) {
                request.setAttribute("error","Problem with resources closing");
            }finally {
                try {
                    topicDao.close();
                } catch (DAOException e) {
                    request.setAttribute("error", "Problem with resources closing");
                }
            }
        }
       String sid = request.getParameter("topID");
        Integer id = null;
        Integer idSection = null;
        String sidSection = null;
        if(sid.isEmpty()){
            sidSection = request.getParameter("sectionID");
            idSection = Integer.parseInt(sidSection);
        } else{
            id = Integer.parseInt(sid);
        }



        Topic topic;
        TopicDao topicDao = null;
        List <Section> listSections;
        SectionDao sectionDao = null;
        MySqlDaoFactory daoFactory = new MySqlDaoFactory();


        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<ListOfTopicsInInfoMaterial> listOfTopics =
                    (List<ListOfTopicsInInfoMaterial>) session.getAttribute("listOfTop");
            topicDao = daoFactory.createTopicDao();
            sectionDao = daoFactory.createSectionDao();
            topic = topicDao.read(listOfTopics.get(id));
            listSections = sectionDao.read(topic);
            session.setAttribute("listOfSections", listSections);

            request.setAttribute("user", user.getFirstName() +" "+ user.getSecondName());
            request.setAttribute("topic_name", topic.getTopicName());
            request.setAttribute("topic_description", topic.getTopicDescription());
            for(int i=0; i<listSections.size(); i++){
                request.setAttribute("section_name"+i, listSections.get(i).getSectionName());
            }
            request.setAttribute("section_content", listSections.get(idSection).getSectionContext());
           // if (sidSection.isEmpty()){
            getServletContext().getRequestDispatcher("/page3.jsp").forward(request, response);
            //} else {
             //   getServletContext().getRequestDispatcher("/page4.jsp").forward(request, response);
            //}
        } catch (DAOException e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it");
        } catch (Exception e) {
            request.setAttribute("error", "Sorry, we have a problem and we are working on it. Exception");
        }finally {
            try {
                sectionDao.close();
            } catch (DAOException e) {
                request.setAttribute("error","Problem with resources closing");
            }finally {
                try {
                    topicDao.close();
                } catch (DAOException e) {
                    request.setAttribute("error", "Problem with resources closing");
                }
            }
        }*/
    }
}
