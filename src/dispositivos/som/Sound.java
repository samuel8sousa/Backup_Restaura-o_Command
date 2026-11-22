package dispositivos.som;

public class Sound {

    private boolean ligado = false;
    private String fonte = "RADIO";
    private int volume = 10;


    public void on() {
        ligado = true;
        System.out.println("Sistema de som ligado");
    }

    public void off() {
        ligado = false;
        System.out.println("Sistema de som desligado");
    }

    public void setCd() {
        fonte = "CD";
        System.out.println("Fonte selecionada: CD");
    }

    public void setDvd() {
        fonte = "DVD";
        System.out.println("Fonte selecionada: DVD");
    }

    public void setRadio() {
        fonte = "RADIO";
        System.out.println("Fonte selecionada: RADIO");
    }

    public void setVolume(int novoVolume) {
        volume = novoVolume;
        System.out.println("Volume do som: " + volume);
    }


    public boolean isLigado() {
        return ligado;
    }

    public String getFonte() {
        return fonte;
    }

    public int getVolume() {
        return volume;
    }
}
