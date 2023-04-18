import javax.swing. *;

public class Menu {
    public static void main(String [] args){
        Medienverwaltung m = new Medienverwaltung();
        menueCreate(m);

    }

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
                    int number = m.berechneErscheinungsjahr();
                    System.out.println(number);
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
    public static void audioAufnehmen(Medienverwaltung m){
        String titel = JOptionPane.showInputDialog("Bitte geben Sie den Titel des Audios ein:");
        String interpret = JOptionPane.showInputDialog("Bitte geben Sie den Künstler des Audios ein:");
        int jahr = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie das Erscheinungsjahr des Audios ein:"));
        int dauer = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die Dauer der Audio ein:"));
        Audio audio = new Audio( titel, jahr,interpret, dauer);
        m.aufnehmen(audio);
    }
    public static void bildAufnehmen(Medienverwaltung m){
        String titel = JOptionPane.showInputDialog("Bitte geben Sie den Titel des Bildes ein:");
        String ort = JOptionPane.showInputDialog("Bitte geben Sie den Ort der Aufnahme ein:");
        int jahr = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie das Erscheinungsjahr des Bildes ein:"));
        Bild bild = new Bild(titel, jahr, ort);
        m.aufnehmen(bild);
    }

}
