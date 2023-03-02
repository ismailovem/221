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

        userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("x5",1111)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("x6",222)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("x7",333 )));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("x8",444 )));



        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.print("Id = "+user.getId() + " | ");
            System.out.print("First Name = "+user.getFirstName() + " | ");
            System.out.print("Last Name = "+user.getLastName() + " | ");
            System.out.print("Email = "+user.getEmail() + " | ");
            System.out.print(user.getCarModel() + " | ");
            System.out.print(user.getCarSeries() + " | \n");
        }

        List<User> users1 = userService.selectUserByCar("x8");
        for (User us : users1) {
            System.out.println("========================================================================");
            System.out.print("Id_user = " + us.getId() + " | ");
            System.out.print("First Name = " + us.getFirstName() + " | ");
            System.out.print(us.getCarModel() + "\n");
        }

        context.close();
       }
}
