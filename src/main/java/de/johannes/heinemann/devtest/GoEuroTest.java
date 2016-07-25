package de.johannes.heinemann.devtest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


/**
 * Created by johannes on 19/07/16.
 */
public class GoEuroTest {

    public static void main(String[] args) throws URISyntaxException {
        args = new String[1];
        args[0] = "Potsdam";
        checkArgsForErrors(args);

        String cityName = args[0];
        String url = createAPIEndpointURL(cityName);
        String jsonResponseString = APIQuery.readUrl(url);
        List<LineOfContent> linesOfContent = JSONUtils.readContent(jsonResponseString);

        String csvFile = "./" + cityName + ".csv";
        CSVUtils.writeLines(linesOfContent, csvFile);
    }

    private static String createAPIEndpointURL(String cityName){
        String url = "http://api.goeuro.com/api/v2/position/suggest/en/";
        return url+cityName;
    }

    private static void checkArgsForErrors(String[] args){
        if(args.length < 1) {
            System.out.println("Please add a parameter to query the GoEuro API and try again!");
            System.exit(1);
        }else if(args.length > 1)
            System.out.println("Warning: Only the first parameter is used as input!");

    }



}
