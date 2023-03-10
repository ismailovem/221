package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Component
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "name")
   private String firstName;
   @Column(name = "last_name")
   private String lastName;
   @Column(name = "email")
   private String email;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id", referencedColumnName = "id")
   private Car car;
   @Autowired
   public User() {}
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }
   public String getName() {
      return firstName + " | " + lastName;
   }
   public String getEmail() { return email; }
   public String getCarInfo() {
      return car.getModel() + " | " + car.getSeries();
   }
   @Override
   public String toString() {
      return  id + " | " + getName() + " | " + getEmail();
   }
}
