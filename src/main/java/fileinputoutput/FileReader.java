package fileinputoutput;

import building.Building;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<Building> readFile(String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            List<Building> result = new ArrayList<>();
            br.readLine();
            while ((line = br.readLine()) != null) {
                result.add(transformLineIntoBuilding(line));
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private Building transformLineIntoBuilding(String line) {
        String[] buildingData = line.split(";");
        return new Building(
                buildingData[0],
                buildingData[1],
                buildingData[2],
                Double.parseDouble(buildingData[3]),
                Integer.parseInt(buildingData[4]),
                buildingData[5]
        );
    }
}
