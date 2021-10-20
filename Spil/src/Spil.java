import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class Spil {

    public static void main(String[] args){
        Spil spil = new Spil();
        spil.welcome();
    }

    Felt tower = new Felt(1, "tower", 250, false, 2);
    Felt crater = new Felt(2, "Crater", -100, false, 3);
    Felt palace_gates = new Felt(3, "Palace Gates", 100, false, 4);
    Felt cold_desert = new Felt(4, "Cold Desert", -20, false, 5);
    Felt walled_city = new Felt(5, "Walled City", 180, false, 6);
    Felt monastery = new Felt(6, "Monastery", 0, false, 7);
    Felt black_cave = new Felt(7, "Black Cave", -70, false, 8);
    Felt huts_in_the_mountain = new Felt(8, "Huts In The Mountain", 60, false, 9);
    Felt the_werewall = new Felt(9, "The Werewall", -80, true, 10);
    Felt the_pit = new Felt(10, "The Pit", -50, false, 11);
    Felt goldmine = new Felt(11, "Goldmine", 650, false, 12);

    public void welcome() {
        baggrundsMusik();
        pokemonTekstPrint( "Velkommen til del 2 af CDIO projektet.", 100);
        pokemonTekstPrint("Tast 's' for at starte spillet.", 100);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equalsIgnoreCase("s")) {
            kørSpil();
        }
    }

    public void kørSpil() {
        Spiller spiller1 = new Spiller("player 1", 1000, 0);
        Spiller spiller2 = new Spiller("player 2", 1000, 0);
        Scanner scanner = new Scanner(System.in);
        introduction(spiller1, spiller2);

        while (spiller1.konto.getBalance() < 3000 || spiller2.konto.getBalance() < 3000) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("a")) {
                playerTurn(spiller1);
            }
            if (input.equalsIgnoreCase("l")) {
                playerTurn(spiller2);
            }
            if (input.equalsIgnoreCase("e")){
                pokemonTekstPrint("Spillet er blevet afsluttet. Tak fordi I spillede!", 100);
                break;
            }
            if (input.equalsIgnoreCase("r")){
                pokemonTekstPrint("Spillet bliver genstartet. Vent et øjeblik.", 100);
                pause(3000);
                welcome();
            }
            if(spiller1.konto.getBalance() >=3000){
                pokemonTekstPrint("Vinderen er : " + spiller1.getName() + "! Tillykke!", 100);
                break;
            } else if (spiller2.konto.getBalance() >= 3000){
                pokemonTekstPrint("Vinderen er : " + spiller2.getName() + "! Tillykke!", 100);
                break;
            }
        }
    }

    public void introduction(Spiller s1, Spiller s2) {
        pokemonTekstPrint("For at afslutte spillet når som helst, kan I taste 'e'. For at genstarte når som helst, kan I taste 'r'", 100);
        pokemonTekstPrint("Dette spil kræver to spillere. Hvad skal vi kalde dig, spiller 1?: ", 100);
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        s1.setName(name1);
        pause(200);
        pokemonTekstPrint("Velkommen, " + s1.getName() + "!", 100);
        pokemonTekstPrint("Hvad skal vi kalde dig, spiller 2?: ", 100);
        String name2 = scanner.next();
        s2.setName(name2);
        pause(200);
        pokemonTekstPrint("Velkommen, " + s2.getName() + "!", 100);
        pokemonTekstPrint(name1 + ", når du vil slå, skal du bruge tasten 'a'. " + name2 + ", når du vil slå, skal du bruge tasten 'l'.", 100);
        pokemonTekstPrint(name1 + ", du starter.", 100);
    }

    public void playerTurn(Spiller s) {
        s.terninger.diceRoll();
        pokemonTekstPrint("Du har slået: " + s.terninger.diceRoll(), 100);
        s.updatePosition(s.terninger.getFaceValueSum(), s.getPosition());
        if (s.getPosition() <= 12) {
            pokemonTekstPrint("Din position er nu: " + s.getPosition(), 100);
        }
        if (s.getPosition() > 12) {
            s.setPosition(s.getPosition() - 12);
            pokemonTekstPrint("Din position er nu: " + s.getPosition(), 100);
        }
        flows(s);
    }

    public void flows(Spiller s) {
        if (s.getPosition() == tower.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + tower.getInfluenceOnBalance());
            pokemonTekstPrint("Du har fundet 180kr i tårnet! Din balance er på: " + s.konto.getBalance() + "!", 100);

        } else if (s.getPosition() == crater.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + crater.getInfluenceOnBalance());
            pokemonTekstPrint("Øv, du har tabt 100kr i krateret. Din balance er på: " + s.konto.getBalance(), 100);

        } else if (s.getPosition() == palace_gates.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + palace_gates.getInfluenceOnBalance());
            pokemonTekstPrint("Du har lige fundet 100kr ved paladsets porte! Din balance er på: " + s.konto.getBalance() + "!", 100);

        } else if (s.getPosition() == cold_desert.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + cold_desert.getInfluenceOnBalance());
            pokemonTekstPrint("Du har mistet 20kr i den kolde ørken.. Din balance er på: " + s.konto.getBalance(), 100);

        } else if (s.getPosition() == walled_city.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + walled_city.getInfluenceOnBalance());
            pokemonTekstPrint("Du har lige fundet 180kr i Walled City! Din balance er på: " + s.konto.getBalance() + "!", 100);

        } else if (s.getPosition() == monastery.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + monastery.getInfluenceOnBalance());
            pokemonTekstPrint("Du har hverken mistet eller fundet noget i klosteret.. Heldigt eller uheldigt? Din balance er på:  " + s.konto.getBalance(), 100);

        } else if (s.getPosition() == black_cave.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + black_cave.getInfluenceOnBalance());
            pokemonTekstPrint("Du har gjort 70kr væk i den sorte hule.. Din balance er på: " + s.konto.getBalance(), 100);

        } else if (s.getPosition() == huts_in_the_mountain.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + huts_in_the_mountain.getInfluenceOnBalance());
            pokemonTekstPrint("Du har fundet 60kr i hytterne på bjerget! Din balance er på: " + s.konto.getBalance() + "!", 100);

        } else if (s.getPosition() == the_werewall.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + the_werewall.getInfluenceOnBalance());
            pokemonTekstPrint("Du har fået stjålet 80kr ved varulve-væggen.. Din balance er på: " + s.konto.getBalance(), 100);
            pokemonTekstPrint("Men bare rolig, du får også en ekstra tur!", 100);
            playerTurn(s);

        } else if (s.getPosition() == the_pit.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + the_pit.getInfluenceOnBalance());
            pokemonTekstPrint("Har du lige tabt 50kr i hullet?.. Det var godt nok uheldigt.. Din balance er på: " + s.konto.getBalance(), 100);

        } else if (s.getPosition() == goldmine.getPosition()) {
            s.konto.setBalance(s.konto.getBalance() + goldmine.getInfluenceOnBalance());
            pokemonTekstPrint("Du har fundet guld til 650kr i minen! Din balance er på: " + s.konto.getBalance() + "!", 100);
        }
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void pokemonTekstPrint(String tekst, long ms) {
        for (int bogstaver = 0; bogstaver < tekst.length(); bogstaver++) {
            System.out.print(tekst.charAt(bogstaver));
            pause((int) ms);
        }
        System.out.println(" ");
    }

    public static void baggrundsMusik() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("D:\\Projects\\Ny mappe\\CDIO2\\Spil\\src\\musik.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Lydfilen kan ikke afspilles.");
            e.printStackTrace();
        }
    }
}



