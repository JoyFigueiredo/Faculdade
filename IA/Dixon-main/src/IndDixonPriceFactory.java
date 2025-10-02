public class IndDixonPriceFactory implements IndividuoFactory{
    private int ind;

    public IndDixonPriceFactory(int t) {
        this.ind = t;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndDixonPrice(this.ind);
    }
}
