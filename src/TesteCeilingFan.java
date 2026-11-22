
public class TesteCeilingFan {

    public static void main(String[] args) {

        CeilingFan ventilador = new CeilingFan();

        Comando alto = new VentiladorAltoCommand(ventilador);
        Comando medio = new VentiladorMedioCommand(ventilador);
        Comando baixo = new VentiladorBaixoCommand(ventilador);
        Comando desligar = new DesligarVentiladorCommand(ventilador);

        alto.execute();
        System.out.println("Velocidade: " + ventilador.getSpeed());

        medio.execute();
        System.out.println("Velocidade: " + ventilador.getSpeed());

        baixo.execute();
        System.out.println("Velocidade: " + ventilador.getSpeed());

        desligar.execute();
        System.out.println("Velocidade: " + ventilador.getSpeed());
    }
}
