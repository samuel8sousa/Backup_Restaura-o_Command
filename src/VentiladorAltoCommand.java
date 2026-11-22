
public class VentiladorAltoCommand implements Comando {

    private final CeilingFan ventilador;

    public VentiladorAltoCommand(CeilingFan ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void execute() {
        ventilador.high();
    }

    @Override
    public String registro() {
        return "FAN_HIGH";
    }
}
