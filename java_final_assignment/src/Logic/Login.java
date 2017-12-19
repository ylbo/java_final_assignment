package Logic;

import Sql.SqlHelper;
import Windows.ChooseWindows;
import Windows.LoginWindows;
import Windows.SignInWindoes;

import java.awt.event.*;

public class Login {
    private LoginWindows loginWindows;
    private SignInWindoes signInWindoes;
    private ChooseWindows chooseWindows;

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
            if (SqlHelper.checkAccountAndPassword(loginWindows.getAccountField().getText(), loginWindows.getPasswordField().getText())) {
                loginWindows.getDialog().setVisible(true);
                record();
                return;
            }
            loginWindows.getLabelOfDialog().setText("µÇÂ¼³É¹¦");
            loginWindows.getDialog().setVisible(true);
            SqlHelper.account = loginWindows.getAccountField().getText();
            System.out.println(SqlHelper.account);
            chooseWindows.setVisible(true);
            loginWindows.setVisible(false);
        }
    };
    private ActionListener toSignInWindowsChicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            signInWindoes.setVisible(true);
            loginWindows.setVisible(false);
        }
    };

    public Login(LoginWindows loginWindows) {
        this.loginWindows = loginWindows;
        loginWindows.getLogInButton().addActionListener(logInButtonChicked);
        loginWindows.getSignInButton().addActionListener(toSignInWindowsChicked);
        loginWindows.getDialog().addWindowListener(logInDialogChicked);
        loginWindows.getVisiblePasswordButton().addMouseListener(visiblePasswordButtonChicked);
    }

    private void record() {
        logInCount++;
        if (logInCount == 3) {
            logInCount = 0;
            System.exit(0);
        }
    }

    public SignInWindoes getSignInWindoes() {
        return signInWindoes;
    }

    public void setSignInWindoes(SignInWindoes signInWindoes) {
        this.signInWindoes = signInWindoes;
    }

    public void setChooseWindows(ChooseWindows chooseWindows) {
        this.chooseWindows = chooseWindows;
    }
}
