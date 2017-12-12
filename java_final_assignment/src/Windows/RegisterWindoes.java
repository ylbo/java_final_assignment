package Windows;

import java.awt.*;

public class RegisterWindoes extends MyFrame {
    private Label label_user_name;
    private Label label_passwords_input;
    private Label label_passwords_confirm;
    private TextField textField_user_name;
    private TextField textField_passwords_input;
    private TextField textField_passwords_confirm;
    private Button button_register;
    private Button button_quit_register;
    private Button button_visible_password;
    private Dialog dialog;
    private Label label_dialog;
    private Label label_remind;

    public RegisterWindoes()
    {
        super();
        init();
    }
    
    private void init()
    {
        label_user_name = new Label("新用户名");
        label_user_name.setBounds(80, 70, 50, 20);
        label_passwords_input = new Label("输入密码");
        label_passwords_input.setBounds(80, 110, 50, 20);
        label_passwords_confirm = new Label("确认密码");
        label_passwords_confirm.setBounds(80, 150, 50, 20);
        label_remind = new Label("密码必须包含大写小写字母和数字，长度8到12位");
        label_remind.setBounds(110, 130, 270, 20);

        textField_user_name = new TextField();
        textField_user_name.setBounds(150, 70, 160, 20);
        textField_passwords_input = new TextField();
        textField_passwords_input.setEchoChar('*');
        textField_passwords_input.setBounds(150, 110, 160, 20);
        textField_passwords_confirm = new TextField();
        textField_passwords_confirm.setEchoChar('*');
        textField_passwords_confirm.setBounds(150, 150, 160, 20);

        button_visible_password = new Button("显示密码");
        button_visible_password.setBounds(320, 110, 60, 20);
        button_register = new Button("注册");
        button_register.setBounds(110, 190, 90, 30);
        button_quit_register = new Button("退出注册");
        button_quit_register.setBounds(240, 190, 90, 30);

        dialog = new Dialog(this, "杨良博", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(null);
        dialog.setBounds(729, 360, 240, 148);

        label_dialog = new Label("注册失败");
        label_dialog.setBounds(90, 60, 50, 20);

        dialog.add(label_dialog);

        this.add(label_remind);
        this.add(label_user_name);
        this.add(label_passwords_input);
        this.add(label_passwords_confirm);
        this.add(textField_user_name);
        this.add(textField_passwords_input);
        this.add(textField_passwords_confirm);
        this.add(button_register);
        this.add(button_quit_register);
        this.add(button_visible_password);
    }

    public TextField getTextField_user_name() {
        return textField_user_name;
    }

    public TextField getTextField_passwords_input() {
        return textField_passwords_input;
    }

    public TextField getTextField_passwords_confirm() {
        return textField_passwords_confirm;
    }

    public Button getButton_register() {
        return button_register;
    }

    public Button getButton_quit_register() {
        return button_quit_register;
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
