package dispositivos.banheira;

import core.Comando;

public class AtivarCirculacaoCommand implements Comando {

    private final Hottub banheira;

    public AtivarCirculacaoCommand(Hottub banheira) {
        this.banheira = banheira;
    }

    @Override
    public void execute() {
        banheira.circulate();
    }

    @Override
    public String registro() {
        return "HOTTUB_CIRCULATE";
    }
}
