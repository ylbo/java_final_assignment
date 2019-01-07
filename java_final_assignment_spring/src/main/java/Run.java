import Control.*;
import DAO.Domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Run {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("RunConfig.xml");
        Login login = ctx.getBean(Login.class);
        login.setVisible(true);
        User u1 = new User();
        u1.setPassword("111");
        u1.setUserName("111");
        User u2 = new User();
        u2.setUserName("111");
        u2.setPassword("111");
        System.out.println(u1.equals(u2));
    }
}
