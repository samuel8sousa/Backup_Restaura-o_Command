package dispositivos.luz;

import core.Comando;

public class DesligarLuzCommand implements Comando {

    private final Light luz;

    public DesligarLuzCommand(Light luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.off();
    }

    @Override
    public String registro() {
        return "LIGHT_OFF";
    }
}