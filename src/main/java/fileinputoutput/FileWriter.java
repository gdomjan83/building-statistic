package fileinputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class FileWriter {

    public void writeFile(Set<String> cities, String fileName) {
        try {
            Files.write(Path.of("src/main/resources/" + fileName), cities);
        } catch (IOException ioe) {
            throw new IllegalStateException(" Can not write file.", ioe);
        }
    }
}
