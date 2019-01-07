package Control;

import DAO.Domain.User;
import DAO.Implements.UserImp;
import DAO.SqlHelper;
import View.LoginWindows;
import View.SignInWindows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.*;

@Controller
public class Login {
    @Autowired
    public Login(LoginWindows loginWindows, SignInWindows signInWindows) {
        this.signInWindows = signInWindows;
        this.loginWindows = loginWindows;
        loginWindows.getLogInButton().addActionListener(logInButtonChicked);
        loginWindows.getSignInButton().addActionListener(toSignInWindowsChicked);
        loginWindows.getDialog().addWindowListener(logInDialogChicked);
        loginWindows.getVisiblePasswordButton().addMouseListener(visiblePasswordButtonChicked);
    }

    @Autowired
    private UserImp userImp;

    private final LoginWindows loginWindows;

    private final SignInWindows signInWindows;

    public void setVisible(boolean b) {
        loginWindows.setVisible(b);
    }

    private MouseListener visiblePasswordButtonChicked = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            loginWindows.getPasswordField().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            loginWindows.getPasswordField().setEchoChar('*');
        }
    };
    private WindowListener logInDialogChicked = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            loginWindows.getDialog().setVisible(false);
            loginWindows.getLabelOfDialog().setText("µÇÂ¼Ê§°Ü");
        }
    };
    private int logInCount = 0;
    private ActionListener logInButtonChicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User();
            user.setUserName(loginWindows.getAccountField().getText());
            user.setPassword(loginWindows.getPasswordField().getText());
            if (userImp.checkAccountAndPassword(user)) {
                loginWindows.getLabelOfDialog().setText("µÇÂ¼³É¹¦");
                loginWindows.getDialog().setVisible(true);
                SqlHelper.account = loginWindows.getAccountField().getText();
                System.out.println(SqlHelper.account);

                loginWindows.setVisible(false);
            }else{
                loginWindows.getDialog().setVisible(true);
                record();
                return;
            }

        }
    };

    private ActionListener toSignInWindowsChicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            signInWindows.setVisible(true);
            loginWindows.setVisible(false);
        }
    };

    private void record() {
        logInCount++;
        if (logInCount == 3) {
            logInCount = 0;
            System.exit(0);
        }
    }
}
