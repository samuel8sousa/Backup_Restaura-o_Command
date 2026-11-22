package dispositivos.ventilador;

import core.Comando;

public class DesligarVentiladorCommand implements Comando {

    private final CeilingFan ventilador;

    public DesligarVentiladorCommand(CeilingFan ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void execute() {
        ventilador.off();
    }

    @Override
    public String registro() {
        return "FAN_OFF";
    }
}
