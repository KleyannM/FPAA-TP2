package objetos;

public class Rolo {

    private int espessura;
    private int[] custos;

    public Rolo(int e, int[] r) {
        this.espessura = e;
        this.custos = r;
    }

    public int getEspessura() {
        return espessura;
    }

    public int[] getCustos() {
        return custos;
    }

    @Override
    public String toString() {
        return espessura + "mm";
    }

}
