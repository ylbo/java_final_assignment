package Windows;

import java.awt.*;

public class SignInWindoes extends MyFrame {
    private Label accountLabel;
    private Label enterPasswordLabel;
    private Label confirmPasswordLabel;
    private TextField accountField;
    private TextField enterPasswordField;
    private TextField confirmPasswordField;
    private Button signInButton;
    private Button exitButton;
    private Button visiblePasswordButton;
    private Dialog dialog;
    private Label labelOfDialog;
    private Label remindOfLabel;

    public SignInWindoes() {
        super();
        init();
    }

    private void init() {
        accountLabel = new Label("新用户名");
        accountLabel.setBounds(80, 70, 50, 20);
        enterPasswordLabel = new Label("输入密码");
        enterPasswordLabel.setBounds(80, 110, 50, 20);
        confirmPasswordLabel = new Label("确认密码");
        confirmPasswordLabel.setBounds(80, 150, 50, 20);
        remindOfLabel = new Label("密码必须包含大写小写字母和数字，长度8到12位");
        remindOfLabel.setBounds(110, 130, 270, 20);

        accountField = new TextField();
        accountField.setBounds(150, 70, 160, 20);
        enterPasswordField = new TextField();
        enterPasswordField.setEchoChar('*');
        enterPasswordField.setBounds(150, 110, 160, 20);
        confirmPasswordField = new TextField();
        confirmPasswordField.setEchoChar('*');
        confirmPasswordField.setBounds(150, 150, 160, 20);

        visiblePasswordButton = new Button("显示密码");
        visiblePasswordButton.setBounds(320, 110, 60, 20);
        signInButton = new Button("注册");
        signInButton.setBounds(110, 190, 90, 30);
        exitButton = new Button("退出注册");
        exitButton.setBounds(240, 190, 90, 30);

        dialog = new Dialog(this, "杨良博", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(null);
        dialog.setBounds(729, 360, 240, 148);

        labelOfDialog = new Label("注册失败");
        labelOfDialog.setBounds(90, 60, 50, 20);

        dialog.add(labelOfDialog);

        this.add(remindOfLabel);
        this.add(accountLabel);
        this.add(enterPasswordLabel);
        this.add(confirmPasswordLabel);
        this.add(accountField);
        this.add(enterPasswordField);
        this.add(confirmPasswordField);
        this.add(signInButton);
        this.add(exitButton);
        this.add(visiblePasswordButton);
    }

    public TextField getAccountField() {
        return accountField;
    }

    public TextField getEnterPasswordField() {
        return enterPasswordField;
    }

    public TextField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public Button getSignInButton() {
        return signInButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public Button getVisiblePasswordButton() {
        return visiblePasswordButton;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public Label getLabelOfDialog() {
        return labelOfDialog;
    }
}
