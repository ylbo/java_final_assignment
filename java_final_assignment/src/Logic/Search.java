package Logic;

import Windows.SearchWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search {
    private SearchWindows searchWindows;
    public Search(SearchWindows searchWindows)
    {
        this.searchWindows=searchWindows;
        searchWindows.getSearch_button_find_word().addActionListener(search_button);
    }

    ActionListener search_button=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String meaning=null;
            meaning=Data.word.get(searchWindows.getSearch_textField_find().getText());
            if (meaning==null)
                searchWindows.getSearch_textArea_meaning().setText("没有该单词词义");
            else searchWindows.getSearch_textArea_meaning().setText(meaning);

        }
    };

}
