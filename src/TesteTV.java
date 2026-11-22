
public class TesteTV {

    public static void main(String[] args) {

        TV tv = new TV();

        Comando ligar = new LigarTVCommand(tv);

        Comando selecionarEntrada =
                new DefinirEntradaTVCommand(tv, "HDMI1");

        Comando alterarVolume =
                new DefinirVolumeTVCommand(tv, 25);

        Comando desligar = new DesligarTVCommand(tv);

        ligar.execute();
        selecionarEntrada.execute();
        alterarVolume.execute();

        System.out.println("Ligada? " + tv.isLigada());
        System.out.println("Entrada atual: " + tv.getCanalEntrada());
        System.out.println("Volume atual: " + tv.getVolume());

        desligar.execute();

        System.out.println("Ligada apos desligar? " + tv.isLigada());

        System.out.println("Registro: " + ligar.registro());
        System.out.println("Registro: " + selecionarEntrada.registro());
        System.out.println("Registro: " + alterarVolume.registro());
        System.out.println("Registro: " + desligar.registro());
    }
}
