package result;

import building.Building;
import fileinputoutput.FileReader;
import fileinputoutput.FileWriter;

import java.util.*;
import java.util.stream.Collectors;

public class Result {
    private List<Building> buildings;
    private static final double ONE_METER_IN_FOOT = 3.280839895;

    public Result(List<Building> buildings) {
        this.buildings = new FileReader().readFile("src/main/resources/legmagasabb-utf8.txt");
    }

    public int getNumberOfBuildings() {
        return buildings.size();
    }

    public int getTotalFloors() {
        return buildings.stream()
                .mapToInt(Building::getFloors)
                .sum();
    }

    public String getHighestBuilding() {
        Building highest = buildings.stream()
                .max(Comparator.comparingDouble(Building::getHeight))
                .orElseThrow(() -> new IllegalStateException("Can not determine highest building"));
        return highest.toString();
    }

    public boolean checkForItalianBuilding() {
        for (Building actual : buildings) {
            if ("Olaszország".equals(actual.getCountry())) {
                return true;
            }
        }
        return false;
    }

    public long countHighBuildings() {
        return buildings.stream()
                .filter(b -> b.getHeight() * ONE_METER_IN_FOOT > 666)
                .count();
    }

    public String getCountryStatistics() {
        Map<String, Integer> statistics = new LinkedHashMap<>();
        for (Building actual : buildings) {
            statistics.compute(actual.getCountry(), (key, value) -> value == null ? 1 : value + 1);
        }
        return extractMap(statistics);
    }

    public String writeFile() {
        FileWriter writer = new FileWriter();
        String fileName = "nemet.txt";
        Set<String> germanCities = buildings.stream()
                        .filter(b -> "Németország".equals(b.getCountry()))
                        .map(Building::getCity)
                        .collect(Collectors.toSet());
        writer.writeFile(germanCities,fileName);
        return fileName;
    }

    private String extractMap(Map<String, Integer> buildingMap) {
        List<String> buildingData = buildingMap.entrySet().stream()
                .map(e -> e.getKey() + " - " + e.getValue() + " db")
                .toList();
        StringBuilder sb = new StringBuilder();
        for (String actual : buildingData) {
            sb.append(actual);
            sb.append("\n");
        }
        return sb.toString();
    }
}
