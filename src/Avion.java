public class Avion extends Thread {

    private String nom;
    private Aeroport aeroport;

    public Avion(String s) {
        this.nom = s;
    }

    public void run() {
        this.aeroport = Aeroport.getInstance();
        System.out.println("Je suis avion" + this.nom + " sur aeroport " + this.aeroport);
        // demande à l'aéroport de lancer le décollage immédiatement
        this.aeroport.faireDecoller(this);
    }

    public void decoller() {
        System.out.println("Décollage avion" + this.nom + " sur aéroport " + this.aeroport);
        // le décollage prend un certain temps : 1 seconde
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin décollage avion" + this.nom + " sur aéroport " + this.aeroport);
    }
}
