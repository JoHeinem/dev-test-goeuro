package de.johannes.heinemann.devtest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 * Writes the user input into a CVS file.
 *
 * The code to export data to a csv file was adapted from mkyong's "How to export data to CSV file – Java".
 *
 * @author johannes heinemann
 * @see <a href="https://www.mkyong.com/java/how-to-export-data-to-csv-file-java/">Mkyong's csv code</a>
 */
public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';

    private static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    private static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    private static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());


    }

    /**
     * Takes the content of the user input and writes it to a csv file.
     *
     * @param lines the content that should be written to the csv file
     * @param csvFile the path to the csv file
     */
    public static void writeLines(List<LineOfContent> lines, String csvFile) {

        try {
            FileWriter writer = new FileWriter(csvFile);
            writeLine(writer, Arrays.asList("_id", "name", "type", "latitude", "longitude"));

            for (LineOfContent line : lines) {
                writeLine(writer, line.getLine());
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Was not able to access or create the csv file. Please check your access rights!");
            e.printStackTrace();
        }


    }
}
