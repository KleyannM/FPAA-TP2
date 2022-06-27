package objetos;

import java.util.List;

public class Resultado {
    private int menorCusto;
    private List<Rolo> rolosUsados;
    private String tabelaPD;
    private Long tempo;

    public Resultado(int mc, List<Rolo> ru, Long t){
        this.menorCusto = mc;
        this.rolosUsados = ru;
        this.tabelaPD = null;
        this.tempo = t;
    }

    public Resultado(int mc, List<Rolo> ru, Long t, String tab){
        this.menorCusto = mc;
        this.rolosUsados = ru;
        this.tempo = t;
        this.tabelaPD = tab;
    }

    public int getMenorCusto() {
        return menorCusto;
    }

    public List<Rolo> getRolosUsados() {
        return rolosUsados;
    }

    public String getTabelaPD() {
        return tabelaPD;
    }

    @Override
    public String toString(){
        String resultado = "Custo mínimo: " + menorCusto + "\nTempo de execução: " + tempo + "\nRolos usados: " + rolosUsados;

        if(tabelaPD != null){
            resultado = resultado + "\nTabela: \n" + tabelaPD;
        }
        return resultado;
    }
}
