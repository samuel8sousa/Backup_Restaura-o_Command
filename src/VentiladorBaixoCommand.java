public class VentiladorBaixoCommand implements Comando {

    private final CeilingFan ventilador;

    public VentiladorBaixoCommand(CeilingFan ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void execute() {
        ventilador.low();
    }

    @Override
    public String registro() {
        return "FAN_LOW";
    }
}
