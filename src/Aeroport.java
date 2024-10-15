public class Aeroport {

    private static Aeroport instance;

    private Aeroport() {
    }

    public static synchronized Aeroport getInstance() { // version 3
        if (instance == null) instance = new Aeroport();
        return instance;
    }

    /*
    Méthode qui lance le décollage d'un avion
    à tester avec et sans synchronized :
    - avec synchronized les avions décollent les un après les autres, jamais en même temps
    - sans synchronized les avions décollent en même temps
     */
    //public void faireDecoller(Avion avion) {
    public synchronized void faireDecoller(Avion avion) {
        avion.decoller();
    }
}
