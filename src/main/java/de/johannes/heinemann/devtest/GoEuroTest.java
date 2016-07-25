package de.johannes.heinemann.devtest;

import java.util.List;


/**
 * Implements the java development test from GoEuro.
 *
 * The program takes the given parameter form the command line string and
 * queries with it the Location JSON API from GoEuro. The information of
 * _id, name, type, latitude and longitude is stored in a csv file.
 *
 * @author johannes heinemann
 * @see <a href="https://github.com/goeuro/dev-test">Github Site of the Java develpment test from GoEuro</a>
 */
public class GoEuroTest {

    private static final String ENDPOINT_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "Potsdam";
        checkArgsForErrors(args);

        String cityName = args[0];
        String url = createAPIEndpointURL(cityName);
        String jsonResponseString = APIQuery.readUrl(url);
        List<LineOfContent> linesOfContent = JSONUtils.readContent(jsonResponseString);

        String csvFile = "./" + cityName + ".csv";
        CSVUtils.writeLines(linesOfContent, csvFile);
    }

    private static String createAPIEndpointURL(String cityName) {
        return ENDPOINT_URL + cityName;
    }

    private static void checkArgsForErrors(String[] args) {
        if (args.length < 1) {
            System.out.println("Please add a parameter to query the GoEuro API and try again!");
            throw new IllegalArgumentException();
        } else if (args.length > 1)
            System.out.println("Warning: Only the first parameter is used as input!");

    }


}
