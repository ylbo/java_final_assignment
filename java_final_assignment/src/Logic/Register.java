package Logic;

import Windows.RegisterWindoes;

import java.awt.event.*;

public class Register {
    private RegisterWindoes registerWindoes;

    public Register(RegisterWindoes registerWindoes) {
        this.registerWindoes = registerWindoes;
        registerWindoes.getRegister_button_visible_password().addMouseListener(visible_password_button_clicked);
        registerWindoes.getRegister_dialog().addWindowListener(dialog_button);
    }

    private WindowListener dialog_button = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            registerWindoes.getRegister_dialog().setVisible(false);
        }
    };
     void clean_register() {
        registerWindoes.getRegister_textField_user_name().setText(" ");
        registerWindoes.getRegister_textField_passwords_input().setText(" ");
        registerWindoes.getRegister_textField_passwords_confirm().setText(" ");
        registerWindoes.getRegister_textField_user_name().setText("");
        registerWindoes.getRegister_textField_passwords_input().setText("");
        registerWindoes.getRegister_textField_passwords_confirm().setText("");
    }

    private MouseListener visible_password_button_clicked = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            registerWindoes.getRegister_textField_passwords_input().setEchoChar('\0');
            registerWindoes.getRegister_textField_passwords_confirm().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            registerWindoes.getRegister_textField_passwords_input().setEchoChar('*');
            registerWindoes.getRegister_textField_passwords_confirm().setEchoChar('*');
        }
    };
}


