package Windows;

import java.awt.*;

public class TestWindows extends MyFrame {
    private TextArea test_textArea_question;
    private TextField test_textField_answer;
    private Button test_button_submit;
    private Button test_button_show_words_difficulty;
    private Button test_button_put_grade;
    private Button test_button_quit_test_module;

    private Dialog test_finish_dialog;
    private Dialog test_result_dialog;
    private Label test_finish_label_dialog;
    private Label test_result_label_dialog;

    public TestWindows(String s) {
        super(s);
        init();
    }

    private void init() {
        test_textArea_question = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        test_textArea_question.setBounds(15, 40, 420, 170);

        test_textField_answer = new TextField();
        test_textField_answer.setBounds(20, 230, 60, 20);

        test_button_submit = new Button("Ìá½»´ð°¸");
        test_button_submit.setBounds(90, 230, 80, 20);
        test_button_show_words_difficulty = new Button("¿¼ÊÔ½á¹û");
        test_button_show_words_difficulty.setBounds(170, 230, 80, 20);
        test_button_put_grade = new Button("Êä³ö³É¼¨");
        test_button_put_grade.setBounds(250, 230, 80, 20);
        test_button_quit_test_module = new Button("ÍË³ö¿¼ÊÔ");
        test_button_quit_test_module.setBounds(330, 230, 80, 20);

        test_finish_dialog = new Dialog(this, "ÑîÁ¼²©");
        test_finish_dialog.setLayout(null);
        test_finish_dialog.setBounds(729, 360, 240, 148);
        test_result_dialog = new Dialog(this, "ÑîÁ¼²©");
        test_result_dialog.setLayout(null);
        test_result_dialog.setBounds(729, 360, 240, 148);

        test_finish_label_dialog = new Label("¿¼ÊÔ½áÊø");
        test_finish_label_dialog.setBounds(90, 60, 50, 20);
        test_result_label_dialog = new Label("»Ø´ð´íÎó");
        test_result_label_dialog.setBounds(90, 60, 50, 20);

        test_finish_dialog.add(test_finish_label_dialog);
        test_result_dialog.add(test_result_label_dialog);

        this.add(test_textArea_question);
        this.add(test_textField_answer);
        this.add(test_button_submit);
        this.add(test_button_show_words_difficulty);
        this.add(test_button_put_grade);
        this.add(test_button_quit_test_module);
    }

    public TextArea getTest_textArea_question() {
        return test_textArea_question;
    }

    public TextField getTest_textField_answer() {
        return test_textField_answer;
    }

    public Button getTest_button_submit() {
        return test_button_submit;
    }

    public Button getTest_button_show_words_difficulty() {
        return test_button_show_words_difficulty;
    }

    public Button getTest_button_put_grade() {
        return test_button_put_grade;
    }

    public Button getTest_button_quit_test_module() {
        return test_button_quit_test_module;
    }

    public Dialog getTest_finish_dialog() {
        return test_finish_dialog;
    }

    public Dialog getTest_result_dialog() {
        return test_result_dialog;
    }

    public Label getTest_result_label_dialog() {
        return test_result_label_dialog;
    }

}
