public class Light {

    private boolean ligada = false;

    public void on() {
        ligada = true;
        System.out.println("Luz ligada");
    }

    public void off() {
        ligada = false;
        System.out.println("Luz desligada");
    }

    public boolean isLigada() {
        return ligada;
    }
}
