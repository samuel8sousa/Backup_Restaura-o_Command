package dispositivos.seguranca;

import core.Comando;

public class DesarmarSegurancaCommand implements Comando {

    private final SecurityControl seguranca;

    public DesarmarSegurancaCommand(SecurityControl seguranca) {
        this.seguranca = seguranca;
    }

    @Override
    public void execute() {
        seguranca.disarm();
    }

    @Override
    public String registro() {
        return "SECURITY_DISARM";
    }
}
