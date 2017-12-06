package Windows;

import java.awt.*;

public class ChooseWindows extends MyFrame {
    private Button choose_button_search_module;
    private Button choose_button_test_module;

    public ChooseWindows(String s) {
        super(s);
        init();
    }

    private void init() {
        choose_button_search_module = new Button("查找单词");
        choose_button_search_module.setBounds(120, 100, 80, 60);
        choose_button_search_module.setBackground(Color.yellow);

        choose_button_test_module = new Button("测验模式");
        choose_button_test_module.setBounds(240, 100, 80, 60);
        choose_button_test_module.setBackground(Color.CYAN);
        this.add(choose_button_search_module);
        this.add(choose_button_test_module);
    }

    public Button getChoose_button_search_module() {
        return choose_button_search_module;
    }

    public Button getChoose_button_test_module() {
        return choose_button_test_module;
    }
}
