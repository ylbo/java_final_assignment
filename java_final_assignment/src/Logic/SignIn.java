package Logic;

import Windows.LoginWindows;
import Windows.SignInWindoes;

import java.awt.event.*;

public class SignIn {
    private SignInWindoes signInWindoes;
    private LoginWindows loginWindows;

    private WindowListener clickedDialogButton = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            signInWindoes.getDialog().setVisible(false);
            signInWindoes.getLabelOfDialog().setText("×¢²áÊ§°Ü");
        }
    };
    private MouseListener clickedVisiblePasswoedButton = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            signInWindoes.getEnterPasswordField().setEchoChar('\0');
            signInWindoes.getConfirmPasswordField().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            signInWindoes.getEnterPasswordField().setEchoChar('*');
            signInWindoes.getConfirmPasswordField().setEchoChar('*');
        }
    };
    private ActionListener clickedSignInButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkInfo()) {
                signInWindoes.getLabelOfDialog().setText("×¢²á³É¹¦");
                signInWindoes.getDialog().setVisible(true);
                SqlHelper.writeAccountAndPassword(signInWindoes.getAccountField().getText(), signInWindoes.getEnterPasswordField().getText());
                loginWindows.setVisible(true);
                cleanSignIn();
                System.out.println("×¢²á³É¹¦");
                signInWindoes.getDialog().setVisible(false);
                signInWindoes.setVisible(false);
            } else {
                signInWindoes.getDialog().setVisible(true);
                System.out.println("×¢²áÊ§°Ü");
            }
        }
    };

    private ActionListener clickedExitSignInButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginWindows.setVisible(true);
            cleanSignIn();
            signInWindoes.setVisible(false);
        }
    };

    public SignIn(SignInWindoes signInWindoes, LoginWindows loginWindows) {
        this.signInWindoes = signInWindoes;
        this.loginWindows = loginWindows;
        signInWindoes.getVisiblePasswordButton().addMouseListener(clickedVisiblePasswoedButton);
        signInWindoes.getDialog().addWindowListener(clickedDialogButton);
        signInWindoes.getSignInButton().addActionListener(clickedSignInButton);
        signInWindoes.getExitButton().addActionListener(clickedExitSignInButton);
    }

    private boolean checkInfo() {
        return !SqlHelper.checkAccount(signInWindoes.getAccountField().getText()) &&
                signInWindoes.getEnterPasswordField().getText().compareTo(signInWindoes.getConfirmPasswordField().getText()) == 0 &&
                signInWindoes.getAccountField().getText().compareTo("") != 0 &&
                limitPasswordWithRegex(signInWindoes.getEnterPasswordField().getText());
    }

    private void cleanSignIn() {
        signInWindoes.getAccountField().setText(" ");
        signInWindoes.getEnterPasswordField().setText(" ");
        signInWindoes.getConfirmPasswordField().setText(" ");
        signInWindoes.getAccountField().setText("");
        signInWindoes.getEnterPasswordField().setText("");
        signInWindoes.getConfirmPasswordField().setText("");
    }

    private boolean limitPasswordWithRegex(String PW) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,16}$";
        return PW.matches(regex);
    }
}


