package algoritmos;

import java.util.ArrayList;
import java.util.List;

import objetos.BTAtual;
import objetos.Resultado;
import objetos.Rolo;
import utils.Utils;

public class Backtracking {

    public static Resultado resolve(List<Rolo> listaRolos){
        List<Rolo> usados = new ArrayList<>();
        BTAtual aux = new BTAtual(Utils.espInicial(listaRolos));
        int menorTotal = 9999;

        Long inicio = System.nanoTime();
        menorTotal = resolve(listaRolos, aux, usados, menorTotal);
        Long fim = System.nanoTime();
        Long tempo = fim - inicio;

        Resultado resultado = new Resultado(menorTotal, usados, tempo);
        return resultado;
    }

    private static int resolve(List<Rolo> listaRolos, BTAtual atuais, List<Rolo> usados, int menorTotal) {
        Rolo rolo = Utils.getByEspessura(listaRolos, atuais.getEspAtual());

        if (rolo != null) {
            int[] custos = rolo.getCustos();
            for (int i = 0; i < custos.length; i++) {
                if (custos[i] + atuais.getTotalAtual() <= menorTotal) {
                    atuais.add(i, custos, rolo);
                    menorTotal = resolve(listaRolos, atuais, usados, menorTotal);
                    atuais.remove(i,  custos, rolo);
                }
            }

            return menorTotal;
        }

        usados.removeAll(usados);
        usados.addAll(atuais.getUsadosAtual());

        return atuais.getTotalAtual();
    }

}

