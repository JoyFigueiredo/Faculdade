package util;
import java.util.List;

import individuo.Individuo;

public class Ponto {
    public double[] objetivos;  // Objetivos do ponto
    public List<Ponto> S;  // Lista de pontos dominados
    public int n;  // Contagem de dominância
    public int rank;  // Ranking do ponto

    private Individuo ind;  // Indivíduo associado ao ponto

    // Construtor que recebe um indivíduo
    public Ponto(Individuo ind) {
        this.ind = ind;
        objetivos = ind.getObjetivos();
    }

    // Retorna o indivíduo associado ao ponto
    public Individuo getInd() {
        return this.ind;
    }

    // Representação textual do ponto
    public String toString() {
        return ind.toString() + " n: " + n + " rank: " + rank;
    }
}
