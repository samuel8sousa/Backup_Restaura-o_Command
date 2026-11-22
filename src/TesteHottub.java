public class TesteHottub {

    public static void main(String[] args) {

        Hottub banheira = new Hottub();

        Comando circular =
                new AtivarCirculacaoCommand(banheira);

        Comando ligarJatos =
                new LigarJatosCommand(banheira);

        Comando desligarJatos =
                new DesligarJatosCommand(banheira);

        Comando ajustarTemperatura =
                new DefinirTemperaturaCommand(banheira, 38);

        System.out.println("--- Estado inicial ---");
        System.out.println("Circulacao: "
                + banheira.isCirculando());
        System.out.println("Jatos: "
                + banheira.isJatosLigados());
        System.out.println("Temperatura: "
                + banheira.getTemperatura());

        System.out.println("--- Executando comandos ---");

        circular.execute();
        ligarJatos.execute();
        ajustarTemperatura.execute();

        System.out.println("--- Estado configurado ---");
        System.out.println("Circulacao: "
                + banheira.isCirculando());
        System.out.println("Jatos: "
                + banheira.isJatosLigados());
        System.out.println("Temperatura: "
                + banheira.getTemperatura());

        desligarJatos.execute();

        System.out.println("--- Estado final ---");
        System.out.println("Jatos: "
                + banheira.isJatosLigados());

        System.out.println("--- Registros ---");
        System.out.println(circular.registro());
        System.out.println(ligarJatos.registro());
        System.out.println(ajustarTemperatura.registro());
        System.out.println(desligarJatos.registro());
    }
}
