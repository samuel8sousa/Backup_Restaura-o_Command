package dispositivos.banheira;

public class Hottub {

    private boolean circulando = false;
    private boolean jatosLigados = false;
    private int temperatura = 25;


    public void circulate() {
        circulando = true;
        System.out.println("Circulacao da agua ativada");
    }

    public void jetsOn() {
        jatosLigados = true;
        System.out.println("Jatos ligados");
    }

    public void jetsOff() {
        jatosLigados = false;
        System.out.println("Jatos desligados");
    }

    public void setTemperature(int novaTemperatura) {
        temperatura = novaTemperatura;
        System.out.println("Temperatura configurada: "
                + temperatura);
    }

    public boolean isCirculando() {
        return circulando;
    }

    public boolean isJatosLigados() {
        return jatosLigados;
    }

    public int getTemperatura() {
        return temperatura;
    }


}