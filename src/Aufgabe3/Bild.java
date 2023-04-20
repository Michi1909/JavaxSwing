import java.util.Objects;

/**
 * Bild extends from Medium and save Pictures with Details(title, year and location)
 * @author Ella Kaiser
 */
public class Bild extends Medium {
    private String ort;

    public Bild(String titel, int jahr, String ort) {
        super(titel, jahr);
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        Bild a = (Bild) o;
        if (ort != a.ort)
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(ort);
    }

    @Override
    public void druckeDaten() {
        System.out.println(
                "ID = " + getID() + " " + getTitel() + " aufgenommen im Jahr " + getJahr() + " in " + getOrt());
    }

}

