
public class TesteSound {

    public static void main(String[] args) {

        Sound som = new Sound();

        Comando ligar = new LigarSomCommand(som);
        Comando cd = new SelecionarCDCommand(som);
        Comando dvd = new SelecionarDVDCommand(som);
        Comando radio = new SelecionarRadioCommand(som);
        Comando volume = new DefinirVolumeSomCommand(som, 25);
        Comando desligar = new DesligarSomCommand(som);

        ligar.execute();
        cd.execute();
        volume.execute();

        System.out.println("Ligado? " + som.isLigado());
        System.out.println("Fonte: " + som.getFonte());
        System.out.println("Volume: " + som.getVolume());

        dvd.execute();
        radio.execute();

        System.out.println("Fonte atual: " + som.getFonte());

        desligar.execute();

        System.out.println("Ligado apos desligar? "
                + som.isLigado());

        System.out.println("--- Registros ---");

        System.out.println(ligar.registro());
        System.out.println(cd.registro());
        System.out.println(volume.registro());
        System.out.println(dvd.registro());
        System.out.println(radio.registro());
        System.out.println(desligar.registro());
    }
}
