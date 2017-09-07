package TestServlet;/*package TestServlet;

import com.sun.javafx.collections.MappingChange;
import dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AllMethodServlet")
public class AllMethodServlet extends HttpServlet {
    HttpSession session;
    MySqlDaoFactory daoFactory = new MySqlDaoFactory();
    MySqlAccessDao accessDao = null;
    MySqlUserDao userDao = null;
    MySqlMaterialDao materialDao = null;
    MySqlListOfTopicsDao listOfTopicsDao = null;
    MySqlTopicDao topicDao = null;
    MySqlSectionDao sectionDao = null;
    Access access;
    User user = null;
    InfoMaterial material;
    List<ListOfTopicsInInfoMaterial> listOfTopicsInInfoMaterial;
    Topic topic;
    Section section = null;
    List<Section> sectionList;
    String page = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createDAO();

    }

    public void createDAO(){

        try {
            accessDao = daoFactory.createAccessDao();
            userDao = daoFactory.createUserDao();
            listOfTopicsDao = daoFactory.createListOfTopicsDao();
            materialDao = daoFactory.createMaterialDao();
            topicDao = daoFactory.createTopicDao();
            sectionDao = daoFactory.createSectionDao();
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

    protected void setObjects(int i){
        if (i == 1){
            try {
                user = userDao.read(access);

            material = materialDao.read(user);
            listOfTopicsInInfoMaterial = listOfTopicsDao.read(material);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) {
            topic = topicDao.read(listOfTopics.get(topicID));
            sectionList = sectionDao.read(topic);

        }
    }

    protected void setAttributes(HttpServletRequest request, HttpServletResponse response, String atr){
        User user = null;
        try {
            user = userDao.read(access);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        request.setAttribute("user", user.getFirstName() + " " + user.getSecondName());
        if (atr.equals("sectionID")){
            request.setAttribute("section_name", section.getSectionName());
            request.setAttribute("section_content", section.getSectionContext());
            for (int i = 0; i < sectionList.size(); i++) {
                request.setAttribute("section_name" + i, sectionList.get(i).getSectionName());
            }
        }
        if (atr.equals("topicID")){
            request.setAttribute("topic_name", topic.getTopicName());
            request.setAttribute("topic_description", topic.getTopicDescription());
            for (int i = 0; i < sectionList.size(); i++) {
                request.setAttribute("section_name" + i, sectionList.get(i).getSectionName());
            }
        }
        if (atr.equals("login")){
            request.setAttribute("user", user.getFirstName() + " " + user.getSecondName());
            for (int i = 0; i < listOfTopicsInInfoMaterial.size(); i++) {
                request.setAttribute("topic" + i, listOfTopicsInInfoMaterial.get(i).getTopicName());
            }
        }
    }




    protected void handler(HttpServletRequest request, HttpServletResponse response, String stringId){
        Integer id = Integer.parseInt(stringId);
        user = (User) session.getAttribute("user");
        List list;
        String userParam = user.getFirstName() + " " + user.getSecondName();
        Map<String, String> map = new HashMap<>();


        if(stringId.equals("topID")){
            listOfTopicsInInfoMaterial = (List<ListOfTopicsInInfoMaterial>) session.getAttribute("listOfTop");
            list = listOfTopicsInInfoMaterial;
            try {
                topic = topicDao.read(listOfTopicsInInfoMaterial.get(id));
                sectionList = sectionDao.read(topic);
                map.put("topic_name", topic.getTopicName());
                map.put("topic_description", topic.getTopicDescription());

            } catch (DAOException e) {
                e.printStackTrace();
            }
            session.setAttribute("listOfSections", sectionList);

        }
        if(stringId.equals("sectionID")){

            sectionList = (List<Section>) session.getAttribute("listOfSections");
            section = sectionList.get(id);
            map.put("section_name", section.getSectionName());
            map.put("section_content", section.getSectionContext());
        }

        request.setAttribute("user", userParam);
        request.setAttribute(map. );

    }
}
*/