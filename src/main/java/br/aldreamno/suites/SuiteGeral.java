package br.aldreamno.suites;

import br.aldreamno.core.DriverFactory;
import br.aldreamno.pages.LoginPage;
import br.aldreamno.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})
public class SuiteGeral {

    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializa(){
        page.acessarTelaInicial();
        page.setEmail("aldrea.mno@gmail.com");
        page.setSenha("123456");
        page.entrar();
    }

    @AfterClass
    public static void finaliza(){
        //DriverFactory.killDriver();
    }
}
