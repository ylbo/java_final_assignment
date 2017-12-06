package Windows;

import java.awt.*;

public class SearchWindows extends MyFrame {
    private Label search_label_find;
    private TextField search_textField_find;
    private Button search_button_find_word;
    private TextArea search_textArea_meaning;
    private Button search_button_quit_search_module;
    
    public SearchWindows(String s)
    {
        super(s);
        init();
    }
    
    private void init()
    {
        search_label_find = new Label("输入单词");
        search_label_find.setBounds(15, 35, 60, 20);

        search_textField_find = new TextField();
        search_textField_find.setBounds(80, 35, 240, 20);

        search_textArea_meaning = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        search_textArea_meaning.setBounds(15, 60, 410, 160);

        search_button_find_word = new Button("搜索");
        search_button_find_word.setBounds(340, 35, 80, 20);
        search_button_quit_search_module = new Button("退出查询");
        search_button_quit_search_module.setBounds(340, 230, 80, 20);

        this.add(search_label_find);
        this.add(search_textField_find);
        this.add(search_button_find_word);
        this.add(search_textArea_meaning);
        this.add(search_button_quit_search_module);
    }

    public TextField getSearch_textField_find() {
        return search_textField_find;
    }

    public Button getSearch_button_find_word() {
        return search_button_find_word;
    }

    public TextArea getSearch_textArea_meaning() {
        return search_textArea_meaning;
    }

    public Button getSearch_button_quit_search_module() {
        return search_button_quit_search_module;
    }
}
