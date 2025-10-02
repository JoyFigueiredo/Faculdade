package individuo;
import java.util.ArrayList;
import java.util.List;

import operadores.crossover.CrossOver;
import operadores.crossover.impl.CrossOverBLXAlfa;
import operadores.mutation.Mutation;
import operadores.mutation.impl.MutationNone;
import problema.Problema;

public class Individuo {

    private double[] genes;  // Variáveis de decisão
    private double[] objetivos;  // Valores dos objetivos
    public double d;  // Distância de crowding

    private Problema problema;  // Problema associado ao indivíduo
    private CrossOver crossOver;
    private Mutation mutation;

    // Construtor que recebe um problema e as variáveis de decisão
    public Individuo(Problema problema, double[] genes) {
        this(problema, genes, new CrossOverBLXAlfa(0.1), new MutationNone());
    }

    public Individuo(Problema problema, double[] genes, CrossOver crossOver, Mutation mutation) {
        this.problema = problema;
        this.genes = genes;
        this.crossOver = crossOver;
        this.mutation = mutation;
    }

    /*
     * 
     // Construtor que recebe um problema específico (ProblemaExemplo) e as variáveis de decisão
     public Individuo(ProblemaExemplo problema, double[] genes) {
        this.problema = problema;
        this.genes = genes;
    }
    */

    // Retorna os valores dos objetivos, avaliando-os se ainda não foram calculados
    public double[] getObjetivos() {
        if (objetivos == null) {
            objetivos = problema.avaliar(genes);
        }
        return objetivos;
    }

    public List<Individuo> recombinar(Individuo p2) {
        List<Individuo> filhos = new ArrayList<Individuo>(2);

        //retorna a matriz de filhos. Primeira linha é o primeiro filho e a segunda linha é o segundo filho
        //-50 a 50
        double[][] filhosMat = crossOver.getOffSpring(this.genes, p2.genes, new double[] {-50,-50}, new double[] {50,50});
        
        Individuo f1 = new Individuo(this.problema, filhosMat[0]); // Cria filho com problema do pai
        Individuo f2 = new Individuo(this.problema, filhosMat[1]); // Cria filho com problema do pai
        filhos.add(f1);
        filhos.add(f2);

        return filhos;
    }

    // Realiza a mutação do indivíduo
    public void mutar() {
        this.genes = mutation.getMutate(this.genes, new double[] {-50,-50}, new double[] {50,50});
    }

    // Representação textual do indivíduo
    public String toString() {
        String ret = "Individuo - genes[";
        for (int i = 0; i < genes.length; i++) {
            if (i==genes.length-1) {
                ret += genes[i] + " ]";
                
            } else {
                ret += genes[i] + ", ";
            }
        }

        ret = ret + " - objetivos[";
        for (int i = 0; i < objetivos.length; i++) {
            if (i==objetivos.length-1) {
                ret += objetivos[i] + " ]";
                
            } else {
                ret += objetivos[i] + ", ";
            }
        }
        return ret;
    }
}
