package br.aldreamno.tests;

import br.aldreamno.core.BaseTest;
import br.aldreamno.core.Propriedades;
import br.aldreamno.pages.HomePage;
import br.aldreamno.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void testSaldoConta(){
        menu.acessarTelaPrincipal();
        Assert.assertEquals("800.00",page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
    }
}
