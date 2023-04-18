import javax.swing. *;
import java.util.Formatter;

/**
 * Print and manage the methodes from the menue
 * @author Ella Kaiser
 */
public class Menu {
    public static void main(String [] args){
        Medienverwaltung m = new Medienverwaltung();
        menueCreate(m);

    }

    /**
     * Switch Case selected the Input in Menue
     * @param m Generic List of Medium
     */
    public static void menueCreate(Medienverwaltung m){
        boolean running = true;
        while (running) {

            int option= menueOutputInput();

            switch (option) {
                case 1:
                    audioAufnehmen(m);
                    break;

                case 2:
                    bildAufnehmen(m);
                    break;

                case 3:
                    m.zeigeMedium();
                    break;

                case 4:
                    Medium medium = m.sucheNeuesMedium();
                    medium.druckeDaten();
                    break;

                case 5:
                    Formatter f = new Formatter();
                    f.format("%d Average Year",m.berechneErscheinungsjahr());
                    JOptionPane.showMessageDialog(null, f);
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Programm beendet.");

    }

    /**
     * Print menue in JOptionPane
     * @return the input in the menue
     */
    public static int menueOutputInput(){
        int option = 0;
        String input = JOptionPane.showInputDialog("Bitte wählen Sie eine Option aus:\n"
                + "1. Audio aufnehmen\n"
                + "2. Bild aufnehmen\n"
                + "3. Zeige alle Medien\n"
                + "4. Zeige neues Medium\n"
                + "5. Berechne durchschnittliches Erscheinungsjahr\n"
                + "6. Beenden");
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ungültige Eingabe: Bitte wählen Sie eine Option von 1 bis 6.");
        }
        return option;
    }

    /**
     * add an Audio in the Generic list of Medium
     * @param m generic list of Medium
     */
    public static void audioAufnehmen(Medienverwaltung m){
        String titel = JOptionPane.showInputDialog("Bitte geben Sie den Titel des Audios ein:");
        String interpret = JOptionPane.showInputDialog("Bitte geben Sie den Künstler des Audios ein:");
        int jahr = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie das Erscheinungsjahr des Audios ein:"));
        int dauer = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die Dauer der Audio ein:"));
        Audio audio = new Audio( titel, jahr,interpret, dauer);
        m.aufnehmen(audio);
    }

    /**
     * add a picture in the generic list of medium
     * @param m generic list of medium
     */
    public static void bildAufnehmen(Medienverwaltung m){
        String titel = JOptionPane.showInputDialog("Bitte geben Sie den Titel des Bildes ein:");
        String ort = JOptionPane.showInputDialog("Bitte geben Sie den Ort der Aufnahme ein:");
        int jahr = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie das Erscheinungsjahr des Bildes ein:"));
        Bild bild = new Bild(titel, jahr, ort);
        m.aufnehmen(bild);
    }

}
