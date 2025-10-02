package individuo;

import problema.Problema;
import problema.ProblemaShaffer;

public class IndividuoShafferFactory implements IndividuoFactory {

    private Problema problema;

    public IndividuoShafferFactory() {
        this.problema = new ProblemaShaffer();
    }

    public Individuo getIndividuo() {
        double[] vars = new double[2];

        for (int i = 0; i < vars.length; i++) {
            vars[i] = Math.random() * 100 - 50;
        }

        Individuo ret = new Individuo(this.problema, vars);

        return ret;
    }
}
