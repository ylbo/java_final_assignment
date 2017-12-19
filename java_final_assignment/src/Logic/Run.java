package Logic;

import Windows.*;

public class Run {


    private Run() {
        // create windows
        LoginWindows loginWindows = new LoginWindows();
        SignInWindoes signInWindoes = new SignInWindoes();
        ChooseWindows chooseWindows = new ChooseWindows();
        SearchWindows searchWindows = new SearchWindows();
        TestWindows testWindows = new TestWindows();
        TranslateWindows translateWindows = new TranslateWindows();
        ChooseTestWindows chooseTestWindows = new ChooseTestWindows();

        // create logic
        Login login = new Login(loginWindows);
        SignIn signIn = new SignIn(signInWindoes);
        Search search = new Search(searchWindows);
        Test test = new Test(testWindows);
        Translate translate = new Translate(translateWindows);
        ChooseTest chooseTest = new ChooseTest(chooseTestWindows);

        // connect
        login.setSignInWindoes(signInWindoes);
        login.setChooseWindows(chooseWindows);

        signIn.setLoginWindows(loginWindows);

        searchWindows.setChooseWindows(chooseWindows);
        translateWindows.setChooseWindows(chooseWindows);
        testWindows.setChooseWindows(chooseWindows);
        chooseWindows.setTranslateWindows(translateWindows);
        chooseWindows.setSearchWindows(searchWindows);
        chooseWindows.setChooseTestWindows(chooseTestWindows);

        chooseTest.setTestWindows(testWindows);

        testWindows.setTest(test);
    }

    public static void main(String[] args) {
        new Run();
    }
}
