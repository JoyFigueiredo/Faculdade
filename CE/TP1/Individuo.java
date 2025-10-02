import java.util.ArrayList;
import java.util.Arrays;

public class Individuo {
    ArrayList<Individuo> dominados = new ArrayList<>();
    int n, r; // n: número de soluções que dominam este indivíduo, r: ranking (fronteira)
    double[] genes; // Genes do indivíduo
    double[] objetivos; // Valores dos objetivos do indivíduo

    // Construtor para inicializar os genes e objetivos do indivíduo
    public Individuo(int qtdGenes, int qtdObjt) {
        this.genes = new double[qtdGenes];
        this.objetivos = new double[qtdObjt];
    }

    // Construtor para copiar os genes e objetivos do indivíduo
    public Individuo(double[] genes, double[] objetivos) {
        this.genes = Arrays.copyOf(genes, genes.length);
        this.objetivos = Arrays.copyOf(objetivos, objetivos.length);
    }
}
