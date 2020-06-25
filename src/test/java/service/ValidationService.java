package service;

import org.testng.Assert;

public class ValidationService {

    public void validateOutput(String actual, String expected) {
        Assert.assertEquals(actual,expected);
    }
}
