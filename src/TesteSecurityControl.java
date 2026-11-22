public class TesteSecurityControl {

    public static void main(String[] args) {

        SecurityControl seguranca = new SecurityControl();

        Comando armar =
                new ArmarSegurancaCommand(seguranca);

        Comando desarmar =
                new DesarmarSegurancaCommand(seguranca);

        System.out.println("--- Estado inicial ---");
        System.out.println("Armado? " + seguranca.isArmado());

        System.out.println("--- Armando seguranca ---");
        armar.execute();

        System.out.println("Armado? " + seguranca.isArmado());

        System.out.println("--- Desarmando seguranca ---");
        desarmar.execute();

        System.out.println("Armado? " + seguranca.isArmado());

        System.out.println("--- Armando novamente ---");
        armar.execute();

        System.out.println("Estado final: "
                + seguranca.isArmado());

        System.out.println("--- Registros ---");
        System.out.println(armar.registro());
        System.out.println(desarmar.registro());
        System.out.println(armar.registro());
    }
}
