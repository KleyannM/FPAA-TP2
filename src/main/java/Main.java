import algoritmos.Backtracking;
import algoritmos.Guloso;
import algoritmos.ProgDinamica;
import objetos.Resultado;
import objetos.Rolo;
import utils.Utils;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<List<Rolo>> testes = new ArrayList<>();
        testes.add(Utils.getRolos("./src/entradas/LaminacaoTeste1.txt"));
        testes.add(Utils.getRolos("./src/entradas/LaminacaoTeste2.txt"));
        testes.add(Utils.getRolos("./src/entradas/LaminacaoTeste3.txt"));
        testes.add(Utils.getRolos("./src/entradas/LaminacaoTeste4.txt"));

        int teste = 1;

        for(List<Rolo> listaRolos : testes){
            System.out.println("--------------[ TESTE " + teste + " ]--------------");
            if(listaRolos == null) {
                System.out.println("Erro ao ler o arquivo de teste " + teste);
                teste++;
                continue;
            }

            Long inicio;
            Long fim;
            Long tempoTotal;

            System.out.println("\n[ Programação Dinâmica ]\n");
            Resultado resultadoPD = ProgDinamica.resolve(listaRolos);
            System.out.println(resultadoPD);

            System.out.println("\n\n[ Backtracking ]\n");
            Resultado resultadoBT = Backtracking.resolve(listaRolos);
            System.out.println(resultadoBT);

            System.out.println("\n\n[ Guloso ]\n");
            Resultado resultadoG = Guloso.resolve(listaRolos);
            System.out.println(resultadoG);



            teste++;
        }
    }

}
