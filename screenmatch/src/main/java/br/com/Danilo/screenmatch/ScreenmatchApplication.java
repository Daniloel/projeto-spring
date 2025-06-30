package br.com.Danilo.screenmatch;

import br.com.Danilo.Model.DadosEpisodio;
import br.com.Danilo.Model.DadosSeries;
import br.com.Danilo.Model.DadosTemporada;
import br.com.Danilo.service.ConsumoApi;
import br.com.Danilo.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ConsumoApi consumoApi = new ConsumoApi();
        var json = consumoApi.ObterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
        //System.out.println(json);

        ConverteDados conversor = new ConverteDados();
        DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
        System.out.println(dados);

        json = consumoApi.ObterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);


        List<DadosTemporada> temporadas = new ArrayList();
//
        for (int i = 1; i <= dados.totalTemporadas(); i++) {

            json = consumoApi.ObterDados("https://omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");

            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);

            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);

    }
}
