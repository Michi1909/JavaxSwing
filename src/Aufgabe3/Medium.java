import java.time.LocalDate;
import java.util.Objects;

/**
 * Medium can be a picture and audio
 * a Medium is stored in the medienverwaltung(generic list of medium)
 * @author Ella Kaiser
 */

public abstract class Medium implements Comparable<Medium> {
    private final int ID;
    private static int anzahl = 0;
    private String titel;
    private int jahr;

    public Medium(String titel, int jahr) {
        this.titel = titel;
        this.jahr = jahr;
        this.ID = anzahl;
        anzahl++;
    }
    //TODO: For what was this methode? Looking in the tasks!
    public int alter() {
        LocalDate date = LocalDate.now();
        return date.getYear() - jahr;
    }

    public abstract void druckeDaten();

    @Override
    public int hashCode() {
        return Objects.hash(titel, jahr);
    }
    @Override
    public int compareTo(Medium m){
        return Integer.compare(this.getJahr(),m.getJahr());
    }

    public int getID() {
        return ID;
    }

    public String getTitel() {
        return titel;
    }

    public int getJahr() {
        return jahr;
    }
}
