import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class IndSchwefel extends RealInd {

    public IndSchwefel(int ind) {
        super(ind);
    }

    public double getAvaliacao() {

        if (this.avaliacao < 0) {
            this.avaliacao = 0;

            double soma1 = 0;

            for (int i = 0; i < this.genes.length; i++) {
                soma1 += this.genes[i] * Math.sin(Math.sqrt(Math.abs(this.genes[i])));
            }

            this.avaliacao = 418.9829 * this.genes.length - soma1;
        }
        return this.avaliacao;
    }

    @Override
    protected RealInd instancias(int t) {
        return new IndSchwefel(t);
    }
}