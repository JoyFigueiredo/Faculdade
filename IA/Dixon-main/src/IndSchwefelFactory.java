public class IndSchwefelFactory implements IndividuoFactory{


    private int t;

    public IndSchwefelFactory(int t) {
        this.t = t;
    }
    
    @Override
    public Individuo getIndividuo() {
        return new IndSchwefel(this.t);
    }
}
