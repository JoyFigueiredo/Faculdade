import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class RealInd implements Individuo {
    double[] genes;
    Random rand = new Random();
    double avaliacao;
    double txMutar = 0.15;
    public int ind;

    public RealInd(int ind) {
        Random random = new Random();
        this.genes = new double[ind];
        this.ind = ind;
        this.avaliacao = -1;

        for (int i = 0; i < ind; i++) {
            this.genes[i] = (20)*random.nextDouble() - 10;
        }
    }

    protected abstract RealInd instancias(int nReal);
    /*
     * public RealInd(double[] genes) {
     * this.genes = genes;
     * }
     */

    @Override
    public List<Individuo> recombinarAritm(Individuo ind) {
        Random random = new Random();
        List<Individuo> filhos = new ArrayList<>(2);
        int tam = genes.length;
        double alfa = 0.33;
        // F = (1 - alfa)*P1 +alfa*P2

        /*
         * double[] f1 = new double[genes.length];
         * double[] f2 = new double[genes.length];
         */
        // forma massante
        RealInd f1 = instancias(tam);
        RealInd f2 = instancias(tam);

        RealInd p1 = (RealInd) ind;
        RealInd p2 = (RealInd) ind;

        for (int i = 0; i < tam; i++) {
            double div = random.nextDouble();
            f1.genes[i] = (1 - alfa) * p1.genes[i] + alfa * p2.genes[i] + div;
            f2.genes[i] = (1 - alfa) * p2.genes[i] + alfa * p1.genes[i] + div;

        }

        filhos.add(f1);
        filhos.add(f2);

        return filhos;
    }

    @Override
    public List<Individuo> recombinarBLX(Individuo ind) {
        // F = P1 + α ∗ |P1 − P2|
        int tam = genes.length;
        double alfa = rand.nextGaussian();
        List<Individuo> filhos = new ArrayList<>();
        /*
         * // forma massante
         * double[] f1 = new double[genes.length];
         * double[] f2 = new double[genes.length];
         */
        RealInd f1 = instancias(tam);
        RealInd f2 = instancias(tam);

        RealInd p1 = (RealInd) ind;
        RealInd p2 = (RealInd) ind;
        
        for (int i = 0; i < p1.genes.length; i++) {
            f1.genes[i] = p1.genes[i] + alfa * Math.abs(p1.genes[i] - p2.genes[i]);
            f2.genes[i] = p2.genes[i] + alfa * Math.abs(p1.genes[i] - p2.genes[i]);
        }

        filhos.add(f1);
        filhos.add(f2);

        return filhos;
    }

    @Override
    public Individuo mutar() {
        int cont = 0;
        RealInd mut = instancias(ind);
        double aux;
        for (int i = 0; i < this.genes.length; i++) {
            double r = rand.nextDouble();

            if (r > this.txMutar) {
                mut.getGenes()[i] = this.genes[i];
                // cont ++;
            } else {

                // mut.genes[i] = mut.genes[i] + rand.nextGaussian();
                aux = mut.getGenes()[i] + rand.nextGaussian();
                if (aux > 10.0 || aux < -10.0) {
                    mut.getGenes()[i] = mut.getGenes()[i];
                    // cont++;
                } else {
                    mut.getGenes()[i] = aux;
                    cont++;
                }
            }
        }
        /*
         * if (cont == 0) {
         * int aux2 = rand.nextInt(this.genes.length);
         * mut.genes[aux2] = mut.genes[aux2] + rand.nextGaussian();
         * }
         */
        return mut;
    }

    @Override
    public abstract double getAvaliacao() ;

    @Override
    public double[] getGenes() {
        return this.genes;
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < genes.length; i++) {
            resultado += " " + this.genes[i] + " ";
        }
        resultado += " - Avaliação: " + this.getAvaliacao();

        return resultado;

    }

    @Override
    public int compareTo(Individuo o) {
        if (this.avaliacao > o.getAvaliacao()) {
            return 1;
        }
        return -1;

    }
}
