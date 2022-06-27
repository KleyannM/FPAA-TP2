package objetos;

import java.util.ArrayList;
import java.util.List;

public class BTAtual {
    private int totalAtual;
    private int espAtual;
    private List<Rolo> usadosAtual;

    public BTAtual(int esp){
        this.espAtual = esp;
        this.totalAtual = 0;
        usadosAtual = new ArrayList<>();
    }

    public void add(int i, int[] custos, Rolo rolo){
        usadosAtual.add(rolo);
        espAtual = espAtual - (i+1);
        totalAtual = totalAtual + custos[i];
    }

    public void remove(int i, int[] custos, Rolo rolo){
        usadosAtual.remove(rolo);
        espAtual = espAtual + (i+1);
        totalAtual = totalAtual - custos[i];
    }

    public int getTotalAtual() {
        return totalAtual;
    }

    public int getEspAtual() {
        return espAtual;
    }

    public List<Rolo> getUsadosAtual(){
        return usadosAtual;
    }
}
