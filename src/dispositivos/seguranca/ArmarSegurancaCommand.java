package dispositivos.seguranca;

import core.Comando;


public class ArmarSegurancaCommand implements Comando {

    private final SecurityControl seguranca;

    public ArmarSegurancaCommand(SecurityControl seguranca) {
        this.seguranca = seguranca;
    }

    @Override
    public void execute() {
        seguranca.arm();
    }

    @Override
    public String registro() {
        return "SECURITY_ARM";
    }
}
