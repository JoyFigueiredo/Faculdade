package individuo;
import problema.Problema;
import problema.ProblemaExemplo;

public class Individuo {

    private double[] vars;  // Variáveis de decisão
    private double[] objetivos;  // Valores dos objetivos
    public double d;  // Distância de crowding

    private Problema problema;  // Problema associado ao indivíduo

    // Construtor que recebe um problema e as variáveis de decisão
    public Individuo(Problema problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    // Construtor que recebe um problema específico (ProblemaExemplo) e as variáveis de decisão
    public Individuo(ProblemaExemplo problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    // Retorna os valores dos objetivos, avaliando-os se ainda não foram calculados
    public double[] getObjetivos() {
        if (objetivos == null) {
            objetivos = problema.avaliar(vars);
        }
        return objetivos;
    }

    // Representação textual do indivíduo
    public String toString() {
        String ret = "Individuo - vars[";
        for (int i = 0; i < vars.length; i++) {
            if (i==vars.length-1) {
                ret += vars[i] + " ]";
                
            } else {
                ret += vars[i] + ", ";
            }
        }

        ret = ret + " - objetivos[";
        for (int i = 0; i < objetivos.length; i++) {
            if (i==objetivos.length-1) {
                ret += objetivos[i] + " ]";
                
            } else {
                ret += objetivos[i] + ", ";
            }
        }
        return ret;
    }
}
