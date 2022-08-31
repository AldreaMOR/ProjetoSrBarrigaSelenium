package br.aldreamno.core;

import static br.aldreamno.core.DriverFactory.getDriver;
import static br.aldreamno.core.DriverFactory.KillDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.aldreamno.pages.LoginPage;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void finaliza() throws IOException {

        //*Gerando evidências de screenshot dos testes executados com sucesso.
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshots" +
                File.separator + testName.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER){
            KillDriver();
        }

    }
}
