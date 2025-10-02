package problema;

public class ProblemaExemplo extends Problema{

    @Override
    public double[] avaliar(double[] vars) {
        // Define os objetivos com base nas variáveis de decisão
        if(vars[0] == 0){
            return new double[]{1,5};
        }else if(vars[0] == 1){
            return new double[]{2,3};
        }else if(vars[0] == 2){
            return new double[]{4,1};
        }else if(vars[0] == 3){
            return new double[]{3,4};
        }else if(vars[0] == 4){
            return new double[]{4,3};
        }else if(vars[0] == 5){
            return new double[]{5,5};
        }else if(vars[0] == 6){
            return new double[]{1,5};
        }else if(vars[0] == 7){
            return new double[]{1.5,4};
        }else if(vars[0] == 8){
            return new double[]{2,3};
        }else if(vars[0] == 9){
            return new double[]{4,1};
        }
        return null;
    }

    @Override
    public int getNvars() {
        return 1; // Número de variáveis de decisão
    }

}
