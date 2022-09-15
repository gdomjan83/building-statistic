package result;

import building.Building;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private List<Building> buildings;
    private static final double ONE_METER_IN_FOOT = 3.280839895;

    public Result(List<Building> buildings) {
        this.buildings = buildings;
    }

    public String getNumberOfBuildings() {
        int numberOfBuildings = buildings.size();
        return String.format("Épületek száma: %d db", numberOfBuildings);
    }

    public String getTotalFloors() {
        int floors = buildings.stream()
                .mapToInt(Building::getFloors)
                .sum();
        return String.format("Emeletek összege: %d", floors);
    }

    public String getHighestBuilding() {
        Building highest = buildings.stream()
                .max(Comparator.comparingDouble(Building::getHeight))
                .orElseThrow(() -> new IllegalStateException("Can not determine highest building"));
        return "A legmagasabb épület adatai:\n" + highest.toString();
    }

    public String checkForItalianBuilding() {
        for (Building actual : buildings) {
            if ("Olaszország".equals(actual.getCountry())) {
                return "Van olasz épület az adatok között.";
            }
        }
        return "Nincs olasz épület az adatok között.";
    }

    public String countHighBuildings() {
        long numberOfTallBuildings = buildings.stream()
                .filter(b -> b.getHeight() * ONE_METER_IN_FOOT > 666)
                .count();
        return String.format("666 lábnál magasabb épületek száma: %d", numberOfTallBuildings);
    }

    public String getCountryStatistics() {
        Map<String, Integer> statistics = new LinkedHashMap<>();
        for (Building actual : buildings) {
            statistics.compute(actual.getCountry(), (key, value) -> value == null ? 1 : value + 1);
        }
        return extractMap(statistics);
    }

    private String extractMap(Map<String, Integer> buildingMap) {
        List<String> buildingData = buildingMap.entrySet().stream()
                .map(e -> e.getKey() + " - " + e.getValue() + " db")
                .toList();
        StringBuilder sb = new StringBuilder("Ország statisztika\n");
        for (String actual : buildingData) {
            sb.append(actual);
            sb.append("\n");
        }
        return sb.toString();
    }


}
