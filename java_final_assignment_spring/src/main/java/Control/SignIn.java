package Control;

import DAO.Domain.User;
import DAO.Implements.UserImp;
import View.LoginWindows;
import View.SignInWindows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.*;

@Controller
public class SignIn {
    @Autowired
    public SignIn(SignInWindows signInWindows, LoginWindows loginWindows) {
        this.signInWindows = signInWindows;
        this.loginWindows = loginWindows;
        signInWindows.getVisiblePasswordButton().addMouseListener(clickedVisiblePasswoedButton);
        signInWindows.getDialog().addWindowListener(clickedDialogButton);
        signInWindows.getSignInButton().addActionListener(clickedSignInButton);
        signInWindows.getExitButton().addActionListener(clickedExitSignInButton);

    }

    private final SignInWindows signInWindows;

    private ActionListener clickedSignInButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkInfo()) {
                signInWindows.getLabelOfDialog().setText("×¢²á³É¹¦");
                signInWindows.getDialog().setVisible(true);
                //SqlHelper.writeAccountAndPassword(signInWindows.getAccountField().getText(), signInWindows.getEnterPasswordField().getText());
                User user=new User();
                user.setUserName(signInWindows.getAccountField().getText());
                user.setPassword(signInWindows.getEnterPasswordField().getText());
                userImp.create(user);
                loginWindows.setVisible(true);
                cleanSignIn();
                signInWindows.getDialog().setVisible(false);
                signInWindows.setVisible(false);
            } else {
                signInWindows.getDialog().setVisible(true);
            }
        }
    };

    @Autowired
    private UserImp userImp;

    private final LoginWindows loginWindows;

    private WindowListener clickedDialogButton = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            signInWindows.getDialog().setVisible(false);
            signInWindows.getLabelOfDialog().setText("×¢²áÊ§°Ü");
        }
    };
    private MouseListener clickedVisiblePasswoedButton = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            signInWindows.getEnterPasswordField().setEchoChar('\0');
            signInWindows.getConfirmPasswordField().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            signInWindows.getEnterPasswordField().setEchoChar('*');
            signInWindows.getConfirmPasswordField().setEchoChar('*');
        }
    };


    private ActionListener clickedExitSignInButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginWindows.setVisible(true);
            cleanSignIn();
            signInWindows.setVisible(false);
        }
    };


    private boolean checkInfo() {
        return !userImp.ifUserNameExist(signInWindows.getAccountField().getText()) &&
                signInWindows.getEnterPasswordField().getText().compareTo(signInWindows.getConfirmPasswordField().getText()) == 0 &&
                signInWindows.getAccountField().getText().compareTo("") != 0 &&
                limitPasswordWithRegex(signInWindows.getEnterPasswordField().getText());
    }

    private void cleanSignIn() {
        signInWindows.getAccountField().setText(" ");
        signInWindows.getEnterPasswordField().setText(" ");
        signInWindows.getConfirmPasswordField().setText(" ");
        signInWindows.getAccountField().setText("");
        signInWindows.getEnterPasswordField().setText("");
        signInWindows.getConfirmPasswordField().setText("");
    }

    private boolean limitPasswordWithRegex(String PW) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,16}$";
        return PW.matches(regex);
    }
}


