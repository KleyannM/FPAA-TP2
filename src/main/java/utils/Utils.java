package utils;

import objetos.Rolo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static Rolo getByEspessura(List<Rolo> listaRolos, int esp) {
        for(Rolo rolo : listaRolos){
            if(rolo.getEspessura() == esp)
                return rolo;
        }
        return null;

    }

    public static int espInicial(List<Rolo> listaRolos) {
        int n = 0;
        for(Rolo rolo : listaRolos){
            if (rolo.getEspessura() > n)
                n = rolo.getEspessura();
        }
        return n;
    }

    public static List<Rolo> getRolos(String caminho) throws NullPointerException {
        File file = new File(caminho);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;
        }

        List<Rolo> listaRolos = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();

            List<Integer> rolo = new ArrayList<>();
            for(String v : linha.split(" ")){
                if(v.length() < 1) continue;
                if(!v.equals("x"))
                    rolo.add(Integer.parseInt(v));
            }

            listaRolos.add(new Rolo(rolo.get(0), rolo.stream().skip(1).mapToInt(Integer::intValue).toArray()));
        }

        scanner.close();
        return listaRolos;
    }
}
