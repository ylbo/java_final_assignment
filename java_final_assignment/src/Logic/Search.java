package Logic;

import Windows.SearchWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
    private SearchWindows searchWindows;
    public Search(SearchWindows searchWindows)
    {
        this.searchWindows=searchWindows;
        this.searchWindows.getSearch_button_find_word().addActionListener(search_button);
    }

    ActionListener search_button=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String meaning=null;
            String word =searchWindows.getSearch_textField_find().getText();
            if(word!=null) {
                ResultSet re = Data.search_word_meaning();
                try {
                    while (re.next()) {
                        if (word.compareTo(re.getString("word")) == 0) {
                            meaning = re.getString("meaning");
                        }
                    }
                } catch (SQLException ss) {

                }
            }
            if (meaning==null)
                searchWindows.getSearch_textArea_meaning().setText("没有该单词词义");
            else searchWindows.getSearch_textArea_meaning().setText(meaning);
        }
    };

}
