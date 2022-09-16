package building;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Building {
    private String buildingName;
    private String city;
    private String country;
    private double height;
    private int floors;
    private String yearOfBuild;

    @Override
    public String toString() {
        return String.format("Név: %s\nVáros: %s\nOrszág: %s\nMagasság: %f m\nEmeletek száma: %d\nÉpítés éve: %s",
                buildingName, city, country, height, floors, yearOfBuild);
    }
}
