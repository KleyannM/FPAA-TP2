package algoritmos;

import java.util.ArrayList;
import java.util.List;

import objetos.Resultado;
import objetos.Rolo;
import utils.Utils;

public class ProgDinamica {
    private static final int MAX = 9999;

    public static Resultado resolve(List<Rolo> listaRolos) {
        Long inicio = System.nanoTime();
        // Monta tabela
        int espInicio = Utils.espInicial(listaRolos);

        int t = (espInicio - 3);
        int[][] tab = new int[t][t];

        for (int i = 1; i < tab.length; i++) {
            if(i<t) tab[0][i] = espInicio + 1 - i;
            tab[i][0] = espInicio - i;
        }

        // Calcula e armazena os resultados
        for (int x = 1; x < tab[1].length; x++) {
            int pos = 0;
            int aux = x != 1 ? tab[x - 1][x] : 0;
            Rolo rolo = Utils.getByEspessura(listaRolos, tab[0][x]);

            for (int y = x; y < tab.length; y++) {
                int[] custos = rolo.getCustos();
                if (pos >= custos.length) {
                    tab[y][x] = MAX;
                    continue;
                }

                tab[y][x] = Math.min(x != 1 ? tab[y][x - 1] : MAX, (custos[pos] + aux));
                pos++;
                if(tab[0][y] == tab[x][0] + 1){
                    for (int i = x + 1; i < tab[x].length; i++) {
                        tab[x][i] = tab[x][x];
                    }
                }
            }
        }
        Long fim = System.nanoTime();
        Long tempo = fim - inicio;

        // Gera e retorna o resultado final
        int posFinal = tab.length - 1;

        ArrayList<Rolo> usados = rolosUsados(listaRolos, tab);
        int menorCusto = tab[posFinal][posFinal];

        return new Resultado(menorCusto, usados, tempo, converteTabString(tab));
    }



    private static ArrayList<Rolo> rolosUsados(List<Rolo> listaRolos, int[][] tab) {
        ArrayList<Rolo> usados = new ArrayList<>();

        int x = tab.length - 1;
        int y = x;

        while (x != 0){
            int custo = tab[x][y];
            int aux = tab[x][y-1];
            if(custo == aux){
                y--;
                continue;
            }
            usados.add(Utils.getByEspessura(listaRolos, tab[0][y]));
            x = y-1;
        }

        return usados;
    }

    public static String converteTabString(int[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String prefix = "";
                String sufix = "";
                switch (String.valueOf(matrix[j][i]).length()){
                    case 1: prefix = "  "; sufix = " "; break;
                    case 2: prefix = " "; sufix = " "; break;
                    case 3: prefix = " "; break;
                }
                output = output + (prefix + matrix[j][i] + sufix +"|");
            }
            output = output + "\n";
        }
        output = output.replaceAll("9999", " -- ");
        return output;
    }

}
