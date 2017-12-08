package Windows;

import java.awt.*;

public class SearchWindows extends MyFrame {
    private Label label_find;
    private TextField textField_find;
    private Button button_find_word;
    private TextArea textArea_meaning;
    private Button button_quit_module;

    public SearchWindows()
    {
        super();
        init();
    }
    
    private void init()
    {
        label_find = new Label("输入单词");
        label_find.setBounds(15, 35, 60, 20);

        textField_find = new TextField();
        textField_find.setBounds(80, 35, 240, 20);

        textArea_meaning = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea_meaning.setBounds(15, 60, 410, 160);

        button_find_word = new Button("搜索");
        button_find_word.setBounds(340, 35, 80, 20);
        button_quit_module = new Button("退出查询");
        button_quit_module.setBounds(340, 230, 80, 20);

        this.add(label_find);
        this.add(textField_find);
        this.add(button_find_word);
        this.add(textArea_meaning);
        this.add(button_quit_module);
    }

    public TextField getTextField_find() {
        return textField_find;
    }

    public Button getButton_find_word() {
        return button_find_word;
    }

    public TextArea getTextArea_meaning() {
        return textArea_meaning;
    }

    public Button getButton_quit_module() {
        return button_quit_module;
    }
}
