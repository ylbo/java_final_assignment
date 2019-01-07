package View;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class LoginWindows extends MyFrame {
    private Label accountLabel;
    private Label passwordLabel;
    private TextField accountField;
    private TextField passwordField;
    private Button logInButton;
    private Button signInButton;
    private Button visiblePasswordButton;
    private Dialog dialog;
    private Label labelOfDialog;

    public LoginWindows() {
        super();
        init();
    }

    private void init() {
        accountLabel = new Label("  ÕÊºÅ");
        accountLabel.setBounds(100, 90, 50, 20);

        passwordLabel = new Label("  ÃÜÂë");
        passwordLabel.setBounds(100, 130, 50, 20);

        accountField = new TextField();
        accountField.setBounds(150, 90, 160, 20);

        passwordField = new TextField();
        passwordField.setBounds(150, 130, 160, 20);
        passwordField.setEchoChar('*');

        logInButton = new Button("µÇÂ¼");
        logInButton.setBounds(110, 190, 90, 30);

        signInButton = new Button("×¢²á");
        signInButton.setBounds(240, 190, 90, 30);

        visiblePasswordButton = new Button("ÏÔÊ¾ÃÜÂë");
        visiblePasswordButton.setBounds(320, 130, 60, 20);

        dialog = new Dialog(this, "ÑîÁ¼²©", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setBounds(729, 360, 240, 148);
        dialog.setLayout(null);

        labelOfDialog = new Label("µÇÂ¼Ê§°Ü");
        labelOfDialog.setBounds(90, 60, 50, 20);

        dialog.add(labelOfDialog);

        this.add(accountLabel);
        this.add(passwordLabel);
        this.add(accountField);
        this.add(passwordField);
        this.add(logInButton);
        this.add(signInButton);
        this.add(visiblePasswordButton);
    }

    public TextField getAccountField() {
        return accountField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public Button getLogInButton() {
        return logInButton;
    }

    public Button getSignInButton() {
        return signInButton;
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
