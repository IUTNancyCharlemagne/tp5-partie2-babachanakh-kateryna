public class MainAeroport {
    public static void main(String[] args) {
        Avion avion1 = new Avion("Avion 1");
        Avion avion2 = new Avion("Avion 2");
        Avion avion3 = new Avion("Avion 3");
        Avion avion4 = new Avion("Avion 4");
        // lancement de tous les décollages sans attendre
        avion1.start();
        avion2.start();
        avion3.start();
        avion4.start();
    }
}
