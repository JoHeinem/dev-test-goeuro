package de.johannes.heinemann.devtest;

import java.util.List;

/**
 * Represents one row in a csv file.
 *
 * @author johannes heinemann
 */
public class LineOfContent {

    private List<String> line;

    public LineOfContent(List<String> line) {
        this.line = line;
    }

    public List<String> getLine() {
        return line;
    }
}
