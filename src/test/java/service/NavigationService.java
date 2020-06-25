package service;

import domain.pages.OnlineCalculatorPage;

public class NavigationService {

    private static OnlineCalculatorPage onlineCalculatorPage;

    public void openOnlineCalculator() {
        onlineCalculatorPage = OnlineCalculatorPage.open();
    }

    public void enterInput(String a, String b, String operator) {
        onlineCalculatorPage.enterInput(a, b, operator);
    }

    public String getResult(){
        return onlineCalculatorPage.getResult();
    }

    public void closePage() {
        onlineCalculatorPage.closePage();
    }
}
