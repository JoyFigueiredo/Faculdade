package problema;
public abstract class Problema {
        public Problema(){}

        // Método abstrato para avaliar um conjunto de variáveis de decisão
        public abstract double[] avaliar(double[] vars );

        // Método abstrato que retorna o número de variáveis de decisão do problema
        public abstract int getNvars();
}
