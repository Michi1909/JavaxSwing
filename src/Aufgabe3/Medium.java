import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium> {
    private final int ID;
    private static int anzahl = 0;
    String titel;
    int jahr;

    public Medium(String titel, int jahr) {
        this.titel = titel;
        this.jahr = jahr;
        this.ID = anzahl;
        anzahl++;
    }

    public int alter() {
        LocalDate date = LocalDate.now();
        return date.getYear() - jahr;
    }

    public abstract void druckeDaten();

    @Override
    public int hashCode() {
        return Objects.hash(titel, jahr);
    }

    public int getID() {
        return ID;
    }

    public static int getAnzahl() {
        return anzahl;
    }

    public static void setAnzahl(int anzahl) {
        Medium.anzahl = anzahl;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }
    @Override
    public int compareTo(Medium m){
        return Integer.compare(this.getJahr(),m.getJahr());
    }
}
