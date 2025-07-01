package br.com.Danilo.principal;

import br.com.Danilo.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=" ;
    private final String API_KEY = "&apikey=6585022c";

    public void exibiMenu() {


        System.out.println("Digite o nome da série para a busca");

        var nomeSerie  = leitura.nextLine();

        var consumoApi = new ConsumoApi();

        String endereco = ENDERECO + nomeSerie.replace("","+") + API_KEY;

        var json = consumoApi.ObterDados(endereco);

        System.out.println(json);


    }

}
