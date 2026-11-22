package dispositivos.banheira;

import core.Comando;

public class DesligarJatosCommand implements Comando {

    private final Hottub banheira;

    public DesligarJatosCommand(Hottub banheira) {
        this.banheira = banheira;
    }

    @Override
    public void execute() {
        banheira.jetsOff();
    }

    @Override
    public String registro() {
        return "HOTTUB_JETS_OFF";
    }
}
