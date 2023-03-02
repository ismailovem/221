package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("x5",111)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("x5",111)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("x6",222)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("x7",222)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
        }

        List<User> users1 = userService.selectUserByCar("x5",111);
        for (User us : users1) {
            System.out.println("id_user = " + us.getId());
            System.out.println("name = " + us.getFirstName());
            System.out.println("lastName = " + us.getLastName());
            System.out.println("mail = " + us.getEmail());
            System.out.println("model = " + us.getCarModel());
            System.out.println("series = " + us.getCarSeries());
        }

        context.close();
       }
}
