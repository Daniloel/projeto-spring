package br.com.Danilo.principal;

import br.com.Danilo.Model.DadosEpisodio;
import br.com.Danilo.Model.DadosSeries;
import br.com.Danilo.Model.DadosTemporada;
import br.com.Danilo.service.ConsumoApi;
import br.com.Danilo.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";


    public void exibiMenu() {


        System.out.println("Digite o nome da série para a busca");

        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSeries dados = conversor.obterDados(json, DadosSeries.class);

        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);

       // Never Have I Ever
//        for(int i =0 ; i< dados.totalTemporadas();i++){
//            List<DadosEpisodio> episodiosTempradas = temporadas.get(i).episodios();
//            for (int j =0 ; j <episodiosTempradas.size();j++ ){
//                System.out.println(episodiosTempradas.get(j).titulo());
//            }
//        }


        //Outra maneira de fazer o for-interação
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));



    }

}
