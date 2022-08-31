package br.aldreamno.tests;

import br.aldreamno.core.BaseTest;
import br.aldreamno.core.DriverFactory;
import br.aldreamno.pages.MenuPage;
import br.aldreamno.pages.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static br.aldreamno.core.DriverFactory.getDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Para chamada das funções na ordem por nome
public class ResumoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void test1_ExcluirMovimentacao(){
        menuPage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!",resumoPage.obterMensagemSucesso());

    }

    @Test
    public void test2_ResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

        /*try {
            DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
            Assert.fail();
        } catch (NoSuchElementException e){

        }*/
         List<WebElement> elementosEncontrados =
                 DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
         Assert.assertEquals(0,elementosEncontrados.size());
    }
}
