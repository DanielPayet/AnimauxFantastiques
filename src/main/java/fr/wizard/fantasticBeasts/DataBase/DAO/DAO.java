package fr.wizard.fantasticBeasts.DataBase.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

class DAO {
    protected static String staticPath = "static/";
    static void saveJson(String file, Object o) {
        try {
            Writer writer = new FileWriter(file);
            Gson gson = new GsonBuilder().create();
            gson.toJson(o, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static <T> T getJSON(String path, Class<T> className) {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource(path).getFile())), className);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
