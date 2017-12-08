package Windows;

import java.awt.*;

public class TestWindows extends MyFrame {
    private TextArea textArea_question;
    private TextField textField_answer;
    private Button button_submit;
    private Button button_show_words_difficulty;
    private Button button_put_grade;
    private Button button_quit_module;

    // private Dialog finish_dialog;
    private Dialog result_dialog;
    // private Label finish_label_dialog;
    private Label result_label_dialog;

    public TestWindows() {
        super();
        init();
    }

    private void init() {

        textArea_question = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea_question.setBounds(15, 40, 420, 170);

        textField_answer = new TextField();
        textField_answer.setBounds(20, 230, 60, 20);

        button_submit = new Button("Ìá½»´ð°¸");
        button_submit.setBounds(90, 230, 80, 20);
        button_show_words_difficulty = new Button("¿¼ÊÔ½á¹û");
        button_show_words_difficulty.setBounds(170, 230, 80, 20);
        button_put_grade = new Button("Êä³ö³É¼¨");
        button_put_grade.setBounds(250, 230, 80, 20);
        button_quit_module = new Button("ÍË³ö¿¼ÊÔ");
        button_quit_module.setBounds(330, 230, 80, 20);

        /*finish_dialog = new Dialog(this, "ÑîÁ¼²©");
        finish_dialog.setLayout(null);
        finish_dialog.setBounds(729, 360, 240, 148);*/
        result_dialog = new Dialog(this, "ÑîÁ¼²©");
        result_dialog.setLayout(null);
        result_dialog.setBounds(729, 360, 240, 148);

        /*finish_label_dialog = new Label("¿¼ÊÔ½áÊø");
        finish_label_dialog.setBounds(90, 60, 50, 20);*/
        result_label_dialog = new Label("»Ø´ð´íÎó");
        result_label_dialog.setBounds(90, 60, 50, 20);

        // finish_dialog.add(finish_label_dialog);
        result_dialog.add(result_label_dialog);

        this.add(textArea_question);
        this.add(textField_answer);
        this.add(button_submit);
        this.add(button_show_words_difficulty);
        this.add(button_put_grade);
        this.add(button_quit_module);

    }

    public TextArea getTextArea_question() {
        return textArea_question;
    }

    public TextField getTextField_answer() {
        return textField_answer;
    }

    public Button getButton_submit() {
        return button_submit;
    }

    public Button getButton_show_words_difficulty() {
        return button_show_words_difficulty;
    }

    public Button getButton_put_grade() {
        return button_put_grade;
    }

    public Button getButton_quit_module() {
        return button_quit_module;
    }

    /*public Dialog getFinish_dialog() {
        return finish_dialog;
    }*/

    public Dialog getResult_dialog() {
        return result_dialog;
    }

    public Label getResult_label_dialog() {
        return result_label_dialog;
    }

}
