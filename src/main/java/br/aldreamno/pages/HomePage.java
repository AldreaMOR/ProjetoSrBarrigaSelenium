package br.aldreamno.pages;

import br.aldreamno.core.BasePage;

public class HomePage extends BasePage {
    public String obterSaldoConta(String nome){
      return obterCelula("Conta", nome, "Saldo","tabelaSaldo").getText();
    }
}
