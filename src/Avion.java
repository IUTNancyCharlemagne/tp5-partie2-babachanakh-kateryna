import java.util.Random;

public class Avion extends Thread {

    private String nom;
    private Aeroport aeroport;

    public Avion(String s) {
        super(s);
        this.nom = s;
    }

    public void run() {
        try {
            this.aeroport = Aeroport.getInstance();
            System.out.println("Je suis avion " + this.nom + " et je suis prêt à décoller.");

            // Bloc synchronisé pour attendre que la piste soit libre et décoller
            synchronized (this) {
                while (!this.aeroport.autoriserAdecoller()) {
                    System.out.println("Avion " + this.nom + " en attente de la piste libre.");
                    wait();
                }
                // La piste est libre, on peut décoller
                decoller();
            }
        } catch (InterruptedException e) {
            System.out.println("Avion " + this.nom + " interrompu.");
        }
    }

    public void decoller() throws InterruptedException {
        try {
            System.out.println("Décollage de l'avion " + this.nom);
            int tempsDecollage = new Random().nextInt(1000) + 500;
            Thread.sleep(tempsDecollage);
            System.out.println("Avion " + this.nom + " a décollé et a utilisé la piste pendant " + tempsDecollage + "ms.");
        } finally {
            this.aeroport.libererPiste();
            System.out.println("Avion " + this.nom + " a libéré la piste.");
        }
    }
}
