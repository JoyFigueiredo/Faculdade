public class Main {
    public static void main(String[] args) throws Exception {
        int nPop = 20;
        int elitismo = 2;
        int nGer = 2000;
        IndividuoFactory factory = new IndDixonPriceFactory(4);
        FGA ag = new FGA(); //Algorismo Genetico   

        Individuo melhor = ag.execute(nPop, elitismo, nGer, factory);
    }
}
