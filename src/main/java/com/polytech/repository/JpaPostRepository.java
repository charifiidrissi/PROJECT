package com.polytech.repository;

import com.polytech.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by CODING on 3/13/17.
 */
//@Component
@Repository
@Transactional
public class JpaPostRepository implements PostRepository{


    @PersistenceContext
    private EntityManager entityManager;

    public JpaPostRepository(){

    }

    public List<Post> findAll() {
        //Langage JPQL
        String req = "SELECT p FROM Post p";
        Query query = entityManager.createQuery(req);
        return query.getResultList();
        //JDBC
        /*List<Post> allPosts = new ArrayList<Post>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POST");
            while (resultSet.next()){
                allPosts.add(new Post(resultSet.getString("CONTENT")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allPosts;*/
    }

    public void save(Post post) {
        entityManager.persist(post);
        //JDBC
        /*try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }*/
    }

    @Override
    public List<Post> findById(long id) {
        String req = "SELECT p FROM Post p WHERE p.id like :id";
        Query query = entityManager.createQuery(req);
        query.setParameter("id",id);

        //return entityManager.find(Post.class,id);
        return query.getResultList();
    }

    @Override
    public void saveAndFlash(Post post) {

        entityManager.createQuery("DELETE FROM Post p WHERE id=" + post.getId()).executeUpdate();
    //    entityManager.persist(post);
        //  entityManager.remove(post);
          // entityManager.persist(post);
        //   entityManager.merge(post);
    }
}
