package br.aldreamno.tests;

import br.aldreamno.core.BaseTest;
import br.aldreamno.core.Propriedades;
import br.aldreamno.pages.ContasPage;
import br.aldreamno.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);

        Assert.assertEquals("Conta em uso na movimentações",contasPage.obterMensagemErro());
    }
}
