package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("x5",111)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("x5",111)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("x6",222)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("x7",222)));

        userService.selectUserByCar("x5",111);

        context.close();
       }
}
