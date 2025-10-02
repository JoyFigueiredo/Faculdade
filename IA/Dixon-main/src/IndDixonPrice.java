import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndDixonPrice extends RealInd {

    @Override
    public double getAvaliacao() {
        if (this.avaliacao < 0) {
            this.avaliacao = 0;

            double polinomio = Math.pow(this.genes[0] - 1, 2); // (X1 - 1)^2

            double somatorio = 0;
            for (int i = 1; i < this.genes.length; i++) { // somatorio começando em 1
                somatorio += i * Math.pow((2 * Math.pow(this.genes[i], 2) - this.genes[i - 1]), 2); // i*(2X(i)^2 //
                                                                                                    // X(i-1))^2
            }
            this.avaliacao = polinomio + somatorio;
        }
        return this.avaliacao;// junção dos termos da função
    }

    public IndDixonPrice(int ind) {
        super(ind);
    }

    @Override
    protected RealInd instancias(int nReal) {
        return new IndDixonPrice(nReal);
    }

   

    

}
