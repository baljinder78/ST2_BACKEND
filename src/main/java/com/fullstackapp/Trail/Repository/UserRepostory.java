
package com.fullstackapp.Trail.Repository;


import com.fullstackapp.Trail.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserRepostory {

    @PersistenceUnit(unitName = "allusers")
    private EntityManagerFactory entityManagerFactory;


    public List<User> getallusers()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u from User u",User.class);
        List<User> result = query.getResultList();
        System.out.println(result);
        return result;
    }
}