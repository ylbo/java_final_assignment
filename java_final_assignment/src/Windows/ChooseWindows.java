package Windows;

import java.awt.*;

public class ChooseWindows extends MyFrame {
    private Button button_search_module;
    private Button button_test_module;
    private Button button_translate_module;

    public ChooseWindows() {
        super();
        init();
    }

    private void init() {
        button_search_module = new Button("查找单词");
        button_search_module.setBounds(120, 100, 80, 60);
        button_search_module.setBackground(Color.YELLOW);

        button_test_module = new Button("测验模式");
        button_test_module.setBounds(240, 100, 80, 60);
        button_test_module.setBackground(Color.CYAN);

        button_translate_module = new Button("联网翻译");
        button_translate_module.setBounds(180, 170, 80, 60);
        button_translate_module.setBackground(Color.WHITE);

        this.add(button_translate_module);
        this.add(button_search_module);
        this.add(button_test_module);
    }

    public Button getButton_search_module() {
        return button_search_module;
    }

    public Button getButton_test_module() {
        return button_test_module;
    }

    public Button getButton_translate_module() {
        return button_translate_module;
    }

}
