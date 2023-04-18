
import java.util.Objects;

public class Audio extends Medium {
    private String interpret;
    private int dauer;

    public Audio(String titel, int jahrString, String interpret, int dauer) {
        super(titel, jahrString);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        Audio a = (Audio) o;
        if (interpret!= a.interpret|| dauer != a.dauer)
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(interpret, dauer);
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getID() + " " + getTitel() + " von " + getInterpret() + " aus " + getJahr()
                + " Spieldauer: " + getDauer() + " sek.");
    }

}
