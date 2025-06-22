package br.com.Danilo.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosSeries(@JsonAlias("Title") String Titulo, @JsonAlias("totalSeasons") Integer totalTemporadas, @JsonAlias("imdbRating") String avaliacao) {


}
