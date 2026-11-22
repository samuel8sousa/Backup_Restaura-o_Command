package dispositivos.banheira;

import core.Comando;


public class DefinirTemperaturaCommand implements Comando {

    private final Hottub banheira;
    private final int temperatura;

    public DefinirTemperaturaCommand(
            Hottub banheira, int temperatura) {

        this.banheira = banheira;
        this.temperatura = temperatura;
    }

    @Override
    public void execute() {
        banheira.setTemperature(temperatura);
    }

    @Override
    public String registro() {
        return "HOTTUB_TEMP:" + temperatura;
    }
}
