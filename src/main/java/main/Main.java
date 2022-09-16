package main;

import fileinputoutput.ConsoleWriter;
import fileinputoutput.FileReader;
import result.Result;

public class Main {

    public static void main(String[] args) {
        new ConsoleWriter(
                new Result(
                        new FileReader().readFile("src/main/resources/legmagasabb-utf8.txt"))).writeToConsole();
    }
}
