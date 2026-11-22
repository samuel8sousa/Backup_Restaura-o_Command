public class LigarJatosCommand implements Comando {

    private final Hottub banheira;

    public LigarJatosCommand(Hottub banheira) {
        this.banheira = banheira;
    }

    @Override
    public void execute() {
        banheira.jetsOn();
    }

    @Override
    public String registro() {
        return "HOTTUB_JETS_ON";
    }
}
