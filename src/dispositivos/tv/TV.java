package dispositivos.tv;

public class TV {

    private boolean ligada = false;
    private String canalEntrada = "TV";
    private int volume = 10;

    public void on() {
        ligada = true;
        System.out.println("TV ligada");
    }

    public void off() {
        ligada = false;
        System.out.println("TV desligada");
    }

    public void setInputChannel(String entrada) {
        canalEntrada = entrada;
        System.out.println("Entrada selecionada: " + entrada);
    }

    public void setVolume(int novoVolume) {
        volume = novoVolume;
        System.out.println("Volume da TV: " + volume);
    }

    public boolean isLigada() {
        return ligada;
    }

    public String getCanalEntrada() {
        return canalEntrada;
    }

    public int getVolume() {
        return volume;
    }
}
