package br.aldreamno.tests;

import br.aldreamno.core.BaseTest;
import br.aldreamno.core.Propriedades;
import br.aldreamno.pages.MenuPage;
import br.aldreamno.pages.MovimentacaoPage;
import br.aldreamno.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.aldreamno.utils.DataUtils.obterDataFormatada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Para chamada das funções na ordem por nome
public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void test1_InserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao(obterDataFormatada(new Date()));
        movPage.setDataPagamento(obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação de conta");
        movPage.setInteressado("Interessado meu conhecimento");
        movPage.setValor("800");
        movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

    @Test
    public void test2_CamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.salvar();
        List<String> erros = movPage.obterErros();
        //Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0)); //checando se é a primeira mensagem que aparece
        //Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório")); //checando se contém a mensagem
        Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório","Interessado é obrigatório", "Valor é obrigatório","Valor deve ser um número"))); //checando se possui alguma das mensagens na lista
        Assert.assertEquals(6,erros.size()); //checando que são os 6 erros apresentados no comando anterior
    }

    @Test
    public void test3_InserirMovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação de conta");
        movPage.setInteressado("Interessado meu conhecimento");
        movPage.setValor("800");
        movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movPage.setStatusPago();
        movPage.salvar();

        //Data da movimentação deve ser menor ou igual à data atual
        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual")); //checando se possui alguma das mensagens na lista
        Assert.assertEquals(1,erros.size()); //checando que é 1 erro apresentado no comando anterior
    }

}
