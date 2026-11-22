public class CeilingFan {

    private int velocidade = 0;

    public void high() {
        velocidade = 3;
        System.out.println("Ventilador na velocidade alta");
    }

    public void medium() {
        velocidade = 2;
        System.out.println("Ventilador na velocidade media");
    }

    public void low() {
        velocidade = 1;
        System.out.println("Ventilador na velocidade baixa");
    }

    public void off() {
        velocidade = 0;
        System.out.println("Ventilador desligado");
    }

    public int getSpeed() {
        return velocidade;
    }
}
