package problema;

public abstract class Problema {

        protected int nVars;
        protected double[] lowerBounds;
        protected double[] upperBounds;

        // Método abstrato que retorna o número de variáveis de decisão do problema
        public int getnVars() {
                return nVars;
        }

        public double[] getLowerBounds() {
                return this.lowerBounds;
        }

        public double[] getUpperBounds() {
                return this.upperBounds;
        }

        protected void setLowerBoundsAll(double lower) {
                for (int i = 0; i < lowerBounds.length; i++) {
                        lowerBounds[i] = lower;
                }
        }

        protected void setUpperBoundsAll(double upper) {
                for (int i = 0; i < upperBounds.length; i++) {
                        upperBounds[i] = upper;
                }
        }

        public Problema(int nVars) {
                this.nVars = nVars;
                this.lowerBounds = new double[nVars];
                setLowerBoundsAll(-10);
                this.upperBounds = new double[nVars];
                setUpperBoundsAll(10);
        }

        public Problema() {
                this(2);
        }

        // Método abstrato para avaliar um conjunto de variáveis de decisão
        public abstract double[] avaliar(double[] vars);

}
