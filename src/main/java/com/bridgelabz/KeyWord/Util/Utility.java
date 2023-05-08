package com.bridgelabz.KeyWord.Util;

import com.bridgelabz.KeyWord.Base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Utility extends BaseClass {
    public static void captureScreenshot(){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs((OutputType.FILE));

        File destinationFile = new File(System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis() + "_screenshot.png");

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
