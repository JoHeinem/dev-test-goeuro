package de.johannes.heinemann.devtest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads a string containing a JSON array and transforms it to csv content.
 *
 * Uses the gson library to extract the information within the JSON array.
 *
 * @author johannes heinemann
 * @see <a href="https://github.com/google/gson">Gson github site</a>
 */
public class JSONUtils {

    public static List<LineOfContent> readContent(String jsonResponseString) {
        final Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<JSONObject>>() {
        }.getType();
        Collection<JSONObject> gsonResponse = gson.fromJson(jsonResponseString, collectionType);

        List<LineOfContent> list = new LinkedList<LineOfContent>();
        for (JSONObject city : gsonResponse) {
            List<String> contentList = Arrays.asList(city.get_idAsString(), city.getName(), city.getType(),
                    city.getGeo_position().getLatitudeAsString(), city.getGeo_position().getLongitudeAsString());
            list.add(new LineOfContent(contentList));
        }
        return list;
    }
}
