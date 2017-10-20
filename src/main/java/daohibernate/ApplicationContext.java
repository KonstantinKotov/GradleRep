package daohibernate;

import entity.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import servletshibernate.MethodServlet;
import springdao.*;



import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


@Configuration
@ComponentScan
@EnableTransactionManagement
public class ApplicationContext {

    @Bean
    public UsersAccessEntity usersAccessEntity(){
        UsersAccessEntity usersAccessEntity = new UsersAccessEntity();
        usersAccessEntity.setUsersByAccessId(usersEntity());
        return usersAccessEntity;
    }

    @Bean
    public Collection<UsersEntity> usersEntity(){
        Collection<UsersEntity> usersEntities = new ArrayList<>();
        UsersEntity usersEntity = new UsersEntity();
        usersEntities.add(usersEntity);
        usersEntity.setMaterialsByUserMaterialId(materialEntity());
        return usersEntities;
    }

    @Bean
    public MaterialsEntity materialEntity(){
        MaterialsEntity materialsEntity = new MaterialsEntity();
        materialsEntity.setListoftopicsinmaterialsByMaterialId(listOfTopics());
        return materialsEntity;
    }

    @Bean
    public Collection<ListoftopicsinmaterialEntity> listOfTopics(){
        Collection<ListoftopicsinmaterialEntity> listOfTopics= new ArrayList<>();
        ListoftopicsinmaterialEntity listOfT = new ListoftopicsinmaterialEntity();
        listOfTopics.add(listOfT);
        listOfT.setTopicsByListTopicId(topicsEntity());
        return listOfTopics;
    }

    @Bean
    public TopicsEntity topicsEntity(){
        TopicsEntity topicsEntity = new TopicsEntity();
        topicsEntity.setSectionsByTopicId(sectionEntity());
        return topicsEntity;
    }

    @Bean
    public Collection<SectionsEntity> sectionEntity(){
        Collection<SectionsEntity> sectionsEntities = new ArrayList<>();
        SectionsEntity sectionsEntity = new SectionsEntity();
        sectionsEntities.add(sectionsEntity);
        return sectionsEntities;
    }

    @Bean
    public AccessInt accessSpringDao(){
        return new AccessSpringDao();
    }

    @Bean
    public UserInt userSpringDao(){
        return new UserSpringDao();
    }

    @Bean
    public MaterialInt materialSpringDao(){
        return new MaterialSpringDao();
    }

    @Bean
    public ListOfTopInt listOfTopicsSpringDao(){
        return new ListOfTopicsSpringDao();
    }

    @Bean
    public TopicInt topicSpringDao(){
        return new TopicSpringDao();
    }

    @Bean
    public SectionInt sectionSpringDao(){
        return new SectionSpringDao();
    }


    public MethodServlet methodServlet(){
        AccessInt accessDao = new AccessSpringDao();
        UserInt userDao = new UserSpringDao();
        MaterialInt materialDao = new MaterialSpringDao();
        ListOfTopInt listOfTopDao = new ListOfTopicsSpringDao();
        SectionInt sectionDao = new SectionSpringDao();
        TopicInt topicDao = new TopicSpringDao();

        return new MethodServlet();}

    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(UsersAccessEntity.class, UsersEntity.class, MaterialsEntity.class,
                        ListoftopicsinmaterialEntity.class, TopicsEntity.class, SectionsEntity.class)
                .buildSessionFactory();
    }
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/app1_db");
        dataSource.setUsername("root");
        dataSource.setPassword("sql44");

        return dataSource;
    }
    @Bean
    public HibernateTransactionManager hibTransMan(){
        return new HibernateTransactionManager(sessionFactory());
    }
}
