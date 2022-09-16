package fileinputoutput;

import result.Result;

public class ConsoleWriter {
    private Result result;

    public ConsoleWriter(Result result) {
        this.result = result;
    }

    public void writeToConsole() {
        System.out.printf("3. feladat: Épületek száma: %d db\n", result.getNumberOfBuildings());
        System.out.printf("4. feladat: Emeletek összege: %d\n", result.getTotalFloors());
        System.out.println("5. feladat: A legmagasabb épület adatai:\n" + result.getHighestBuilding());
        String italianBuilding = result.checkForItalianBuilding() ? "Van olasz épület az adatok között." : "Nincs olasz épület az adatok között.";
        System.out.println("6. feladat: " + italianBuilding);
        System.out.printf("7. feladat: 666 lábnál magasabb épületek száma: %d\n", result.countHighBuildings());
        System.out.println("8. feladat: Ország statisztika\n" + result.getCountryStatistics());
        System.out.println("9. feladat: " + result.writeFile());
    }
}
