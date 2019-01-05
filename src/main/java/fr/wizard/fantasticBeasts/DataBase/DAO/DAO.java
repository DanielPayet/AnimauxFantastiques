package fr.wizard.fantasticBeasts.DataBase.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Map;

class DAO {
    protected static String ressourceFolder = "static/";

    static <T> void saveJson(String fileName, Map<Integer, T> o) {
        try {
            File file = new File("src/main/resources/static/" + fileName);
            Writer writer = new FileWriter( file, false);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(o.values().toArray()).replace("\n", "\r\n"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static <T> T getJSON(String path, Class<T> className) {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource(ressourceFolder + path).getFile())), className);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
