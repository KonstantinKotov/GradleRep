package servletshibernate;


import daohibernate.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class ServletListner implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
            HttpSession session = httpSessionEvent.getSession();


        try {
            ManageAccess manageAccess = new ManageAccess();
            ManageUser manageUser = new ManageUser();
            ManageMaterial manageMaterial = new ManageMaterial();
            ManageListOfTopics manageListOfTopics = new ManageListOfTopics();
            ManageTopics manageTopics = new ManageTopics();
            ManageSections manageSections = new ManageSections();


            session.setAttribute("manageAccess", manageAccess);
            session.setAttribute("manageUser", manageUser);
            session.setAttribute("manageMaterial", manageMaterial);
            session.setAttribute("manageListOfTopics", manageListOfTopics);
            session.setAttribute("manageTopics", manageTopics);
            session.setAttribute("manageSections", manageSections);
        } catch (HibernateException e) {
            HibernateException t = new HibernateException(e);
            Logger.getLogger(ServletListner.class.getName()).log(Level.SEVERE,
                    "Error while creating Hibernate obj", t);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        /*Throwable t = null;
        HttpSession session = httpSessionEvent.getSession();
        ManageTopics topic = (ManageTopics) session.getAttribute("topicDao");
        ManageSections section = (ManageSections) session.getAttribute("sectionDao");
        ManageAccess access = (ManageAccess) session.getAttribute("accessDao");
        ManageUser user = (ManageUser) session.getAttribute("userDao");
        ManageListOfTopics listOfTopics = (ManageListOfTopics) session.getAttribute("listOfTopicsDao");
        ManageMaterial material = (ManageMaterial) session.getAttribute("materialDao");

        try {
           session.r
        } catch (DAOException e) {
            t = new DAOException();
        }
        try {
            userDao.close();
        } catch (DAOException e) {
            t = new DAOException();
        }
        try {
            materialDao.close();
        } catch (DAOException e) {
            t = new DAOException();
        }
        try {
            listOfTopicsDao.close();
        } catch (DAOException e) {
            t = new DAOException();
        }
        try {
            topicDao.close();
        } catch (DAOException e) {
            t = new DAOException();
        }
        try {
            sectionDao.close();
        } catch (DAOException e) {
            t = new DAOException();
        }
        if (t != null){
            Logger.getLogger(ServletListner.class.getName()).log(Level.SEVERE,
                    "Error while closing resources", t);
        }*/
    }

}
