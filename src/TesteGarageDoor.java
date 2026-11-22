
public class TesteGarageDoor {

    public static void main(String[] args) {

        GarageDoor garagem = new GarageDoor();

        Comando subir = new SubirGaragemCommand(garagem);
        Comando descer = new DescerGaragemCommand(garagem);
        Comando parar = new PararGaragemCommand(garagem);

        System.out.println("Estado inicial: "
                + garagem.getEstado());

        subir.execute();
        System.out.println("Estado atual: "
                + garagem.getEstado());

        parar.execute();
        System.out.println("Estado atual: "
                + garagem.getEstado());

        descer.execute();
        System.out.println("Estado atual: "
                + garagem.getEstado());

        parar.execute();
        System.out.println("Estado final: "
                + garagem.getEstado());

        System.out.println("--- Registros ---");
        System.out.println(subir.registro());
        System.out.println(parar.registro());
        System.out.println(descer.registro());
        System.out.println(parar.registro());
    }
}
