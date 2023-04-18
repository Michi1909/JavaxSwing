import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medienverwaltung{
    private int anzahl= 0;
    private final List<Medium> mediumverwaltung;

    public Medienverwaltung(){
        this.mediumverwaltung= new ArrayList<>();

    }

    public void aufnehmen(Medium m){
        mediumverwaltung.add(m);
        anzahl++;
    }
    public void zeigeMedium(){
        Collections.sort(mediumverwaltung);
        for(Medium medium : mediumverwaltung){
            medium.druckeDaten();
        }
    }

    public Medium sucheNeuesMedium(){
        if (mediumverwaltung.isEmpty()) {
            return null;
        }
        Medium neuesMedium = mediumverwaltung.get(0);
        for (Medium medium : mediumverwaltung) {
            if (medium.getJahr() > neuesMedium.getJahr()) {
                neuesMedium = medium;
            }
        }
        return neuesMedium;
    }
    public int berechneErscheinungsjahr(){
        if (mediumverwaltung.isEmpty()) {
            return 0;
        }
        int summeJahre = 0;
        for (Medium medium : mediumverwaltung) {
            summeJahre += medium.getJahr();
        }
        return summeJahre / mediumverwaltung.size();

    }

}
