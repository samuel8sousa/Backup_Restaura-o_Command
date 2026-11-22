public class VentiladorMedioCommand implements Comando {

    private final CeilingFan ventilador;

    public VentiladorMedioCommand(CeilingFan ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void execute() {
        ventilador.medium();
    }

    @Override
    public String registro() {
        return "FAN_MEDIUM";
    }
}
