package TestServlet;

import dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by k.kotov on 26.07.2017.
 */
public class FServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getInfoFromDB(req, resp);
       // setRequestParameters(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestParameters(req, resp);
    }

    public  void getInfoFromDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        MySqlDaoFactory daoFactory = new MySqlDaoFactory();
        MySqlAccessDao accessDao = null;
        MySqlUserDao userDao;
        MySqlMaterialDao materialDao;
        MySqlListOfTopicsDao listOfTopicsDao;
        MySqlTopicDao topicDao;
        MySqlSectionDao sectionDao;
        Access access;
        User user;
        InfoMaterial material;
        List<ListOfTopicsInInfoMaterial> listOfTopicsInInfoMaterial;
        Topic topic;
        List<Section> sectionList;

        HttpSession session;

        try {
            accessDao = daoFactory.createAccessDao();
            userDao = daoFactory.createUserDao();
            materialDao = daoFactory.createMaterialDao();
            listOfTopicsDao = daoFactory.createListOfTopicsDao();
            topicDao = daoFactory.createTopicDao();
            sectionDao = daoFactory.createSectionDao();

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
                    session.setAttribute("listOfTopics", listOfTopicsInInfoMaterial);
                    for(int i=0; i<listOfTopicsInInfoMaterial.size(); i++){
                        topic = topicDao.read(listOfTopicsInInfoMaterial.get(i));
                        session.setAttribute("topic_object"+i, topic);
                        sectionList = sectionDao.read(topic);
                        session.setAttribute("sectionList"+i, sectionList);
                    }
                    request.setAttribute("user", user.getFirstName()+" "+user.getSecondName());
                    for(int i=0; i<listOfTopicsInInfoMaterial.size(); i++){
                        request.setAttribute("topic"+i, listOfTopicsInInfoMaterial.get(i).getTopicName());
                    }

                    accessDao.close();
                    userDao.close();
                    materialDao.close();
                    listOfTopicsDao.close();
                    topicDao.close();
                    sectionDao.close();
                    getServletContext().getRequestDispatcher("/page2.jsp").forward(request, response);

                } else {
                    request.setAttribute("message","Incorrect login or password");
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    public  void setRequestParameters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sid = request.getParameter("pageManagerID");
        Integer handlerID = Integer.parseInt(sid);
        HttpSession session = request.getSession();
        List<ListOfTopicsInInfoMaterial>  listOfTopics =
                (List<ListOfTopicsInInfoMaterial>) session.getAttribute("listOfTopics");
        List<Section> currentSectionList = null;
        Section section = null;
        Topic topic = null;
        String page = null;
        switch (handlerID) {
            case 1:
                String topid = request.getParameter("topID");
                Integer topicID = Integer.parseInt(topid);
                List<Section> sectionList = (List<Section>) session.getAttribute("sectionList"+topicID);
                session.setAttribute("currentSectionList", sectionList);
                topic = (Topic) session.getAttribute("topic_object"+topicID);
                request.setAttribute("topic_name", topic.getTopicName());
                request.setAttribute("topic_description", topic.getTopicDescription());
                for(int i=0; i<currentSectionList.size(); i++){
                    request.setAttribute("section"+i, currentSectionList.get(i).getSectionName());
                }
                page = "/page3.jsp";
                break;
            case 2:
                String secid = request.getParameter("sectionID");
                Integer sectionID = Integer.parseInt(secid);
                currentSectionList = (List<Section>) session.getAttribute("currentSectionList");
                section = currentSectionList.get(sectionID);
                page = "/page4.jsp";
                break;
            case 5:
                page = "/page2.jsp";
           // case 3:
             //   String sid = request.getParameter("handler");
              //  Integer handlerID = Integer.parseInt(sid);
               // break;
        }

        User user = (User) session.getAttribute("user");

        request.setAttribute("user", user.getFirstName()+" "+user.getSecondName());
        for(int i=0; i<listOfTopics.size(); i++){
            request.setAttribute("topic"+i, listOfTopics.get(i).getTopicName());
        }
        request.setAttribute("topic_name", topic.getTopicName());
        request.setAttribute("topic_description", topic.getTopicDescription());
        
        for(int i=0; i<currentSectionList.size(); i++){
            request.setAttribute("section"+i, currentSectionList.get(i).getSectionName());
        }
        request.setAttribute("section_name", section.getSectionName());
        request.setAttribute("section_content", section.getSectionContext());
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }



}
