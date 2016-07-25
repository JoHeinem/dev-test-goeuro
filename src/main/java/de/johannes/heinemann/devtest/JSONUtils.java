package de.johannes.heinemann.devtest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by johannes on 19/07/16.
 */
public class JSONUtils {

    public static List<LineOfContent> readContent(String jsonResponseString){
        final Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<City>>(){}.getType();
        Collection<City> gsonResponse = gson.fromJson(jsonResponseString, collectionType);

        List<LineOfContent> list = new LinkedList<LineOfContent>();
        for(City city: gsonResponse){
            List<String> contentList = Arrays.asList(city.get_idAsString(), city.getName(), city.getType(),
                    city.getGeo_position().getLatitudeAsString(), city.getGeo_position().getLongitudeAsString());
            list.add(new LineOfContent(contentList));
        }
        return list;
    }
}
