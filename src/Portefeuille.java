public class Portefeuille {
    private String proprietaire;
    private Cryptomonnaie monnaie;
    private double nombreJetons;

    public Portefeuille(String proprietaire, Cryptomonnaie monnaie, double nombreJetons) {
        this.proprietaire = proprietaire;
        this.monnaie = monnaie;
        this.nombreJetons = nombreJetons;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public Cryptomonnaie getMonnaie() {
        return monnaie;
    }

    public double getNombreJetons() {
        return nombreJetons;
    }

    /**
     * Transfère des jetons vers un autre portefeuille.
     */
    public boolean transfertDevise(Portefeuille destination, double montantJetons) {
        // Vérifie même type de monnaie et montant suffisant
        if (montantJetons < 0
            || !this.monnaie.getNom().equals(destination.getMonnaie().getNom())
            || this.nombreJetons < montantJetons) {
            return false;
        }
        // Retire du portefeuille courant
        this.nombreJetons -= montantJetons;
        // Ajoute dans le portefeuille de destination
        destination.nombreJetons += montantJetons;
        return true;
    }

    /**
     * Achète des jetons en fonction d'un montant en euros.
     */
    public boolean achatDevise(double montantEuros) {
        if (montantEuros < 0) {
            return false;
        }
        // Convertit euros → jetons
        double jetonsAchat = montantEuros / monnaie.getValeurDeJeton();
        this.nombreJetons += jetonsAchat;
        return true;
    }
}
