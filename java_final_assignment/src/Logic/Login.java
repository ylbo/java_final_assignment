package Logic;

import Windows.LoginWindows;

import java.awt.event.*;

public class Login {
    private LoginWindows loginWindows;

    public Login(LoginWindows lw) {
        this.loginWindows = lw;
        loginWindows.getLogin_dialog().addWindowListener(login_dialog_clicked);
        loginWindows.getLogin_button_visible_password().addMouseListener(login_button_visible_password);
    }

    private MouseListener login_button_visible_password = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            loginWindows.getLogin_textField_password().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            loginWindows.getLogin_textField_password().setEchoChar('*');
        }
    };

    private WindowListener login_dialog_clicked = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            loginWindows.getLogin_dialog().setVisible(false);
        }
    };


}
