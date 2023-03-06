package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory
              .getCurrentSession()
              .createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public void selectUserByCar(String model,int series) {
      TypedQuery <User> query = sessionFactory
              .getCurrentSession()
              .createQuery("from User u where u.car.model =: model and u.car.series =: series",User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      List <User> list = query.getResultList();
      for (User user : list) {
         System.out.println(user.getId());
         System.out.println(user.getName());
         System.out.println(user.getEmail());
         System.out.println(user.getCarInfo());
      }
   }
}
