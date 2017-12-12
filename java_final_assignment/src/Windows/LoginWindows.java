package Windows;

import java.awt.*;

public class LoginWindows extends MyFrame {
    private Label label_user_name;
    private Label label_user_passwords;
    private TextField textField_user_name;
    private TextField textField_password;
    private Button button_login;
    private Button button_register;
    private Button button_visible_password;
    private Dialog dialog;
    private Label label_dialog;


    public LoginWindows() {
        super();
        init();
        this.setVisible(true);
    }

    private void init() {
        label_user_name = new Label("  ÕÊºÅ");
        label_user_name.setBounds(100, 90, 50, 20);

        label_user_passwords = new Label("  ÃÜÂë");
        label_user_passwords.setBounds(100, 130, 50, 20);

        textField_user_name = new TextField();
        textField_user_name.setBounds(150, 90, 160, 20);

        textField_password = new TextField();
        textField_password.setBounds(150, 130, 160, 20);
        textField_password.setEchoChar('*');

        button_login = new Button("µÇÂ¼");
        button_login.setBounds(110, 190, 90, 30);

        button_register = new Button("×¢²á");
        button_register.setBounds(240, 190, 90, 30);

        button_visible_password = new Button("ÏÔÊ¾ÃÜÂë");
        button_visible_password.setBounds(320, 130, 60, 20);

        dialog = new Dialog(this, "ÑîÁ¼²©", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setBounds(729, 360, 240, 148);
        dialog.setLayout(null);

        label_dialog = new Label("µÇÂ¼Ê§°Ü");
        label_dialog.setBounds(90, 60, 50, 20);

        dialog.add(label_dialog);

        this.add(label_user_name);
        this.add(label_user_passwords);
        this.add(textField_user_name);
        this.add(textField_password);
        this.add(button_login);
        this.add(button_register);
        this.add(button_visible_password);
    }

    public TextField getTextField_user_name() {
        return textField_user_name;
    }

    public TextField getTextField_password() {
        return textField_password;
    }

    public Button getButton_login() {
        return button_login;
    }

    public Button getButton_register() {
        return button_register;
    }

    public Button getButton_visible_password() {
        return button_visible_password;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public Label getLabel_dialog() {
        return label_dialog;
    }
}
