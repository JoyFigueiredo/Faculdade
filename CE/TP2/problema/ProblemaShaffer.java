package problema;
public class ProblemaShaffer extends Problema {

    private int nVars = 2;  // Número de variáveis de decisão

    @Override
    public double[] avaliar(double[] vars) {
        // Avalia os objetivos com base nas variáveis de decisão
        double[] objetivos = new double[nVars];
        objetivos[0] = Math.pow(vars[0], 2) + Math.pow(vars[1], 2);	
        objetivos[1] = Math.pow(vars[0], 2) + Math.pow(vars[1], 2);	
        return null;
    }

    @Override
    public int getNvars() {
        return 2;  // Número de variáveis de decisão
    }  
}
