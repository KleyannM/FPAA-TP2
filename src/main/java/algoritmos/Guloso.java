package algoritmos;

import java.util.ArrayList;
import java.util.List;

import objetos.Resultado;
import objetos.Rolo;
import utils.Utils;

public class Guloso {
    private static final double MAX = 9999;

    public static Resultado resolve(List<Rolo> listaRolos) {
        Long inicio = System.nanoTime();
        List<Rolo> usados = new ArrayList<>();
        int otimoGlobal = 0;
        int espAtual = Utils.espInicial(listaRolos);

        while (espAtual>4){
            Rolo rolo = Utils.getByEspessura(listaRolos, espAtual);
            int[] custos = rolo.getCustos();
            List<Double> razoes = getRazoes(custos);

            double otimoLocal = MAX;
            for (Double razao : razoes) {
                if (razao < otimoLocal) {
                    otimoLocal = razao;
                }
            }

            usados.add(rolo);
            otimoGlobal = otimoGlobal + custos[razoes.indexOf(otimoLocal)];
            espAtual = espAtual - (razoes.indexOf(otimoLocal) + 1);

        }
        Long fim = System.nanoTime();
        Long tempo = fim - inicio;

        return new Resultado(otimoGlobal, usados, tempo);
    }

    private static List<Double> getRazoes(int[] custos) {
        List<Double> razoes = new ArrayList<>();
        for (int i = 0; i < custos.length; i++) {
            double d = (double) custos[i] / (i + 1);
            razoes.add(d);
        }
        return razoes;
    }

}
