package rs.ac.bg.fon.nprog.json.reports;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.nprog.domen.Trener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class JsonReport {
	

    private static Map<Trener, LocalDateTime> prijaveTrenera;
    private static Map<Trener, LocalDateTime> odjaveTrenera;
    
    final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void generateReport() {
        JsonObject jsonReport = new JsonObject();

        addLoginLogoutInfo(jsonReport);

        writeToAFile(jsonReport);
    }

    private static void addLoginLogoutInfo(JsonObject jsonReport) {
        JsonArray prijaveJsonArray = new JsonArray();
        JsonArray odjaveJsonArray = new JsonArray();

        for (Map.Entry<Trener, LocalDateTime> entry : prijaveTrenera.entrySet()) {
            Trener trener = entry.getKey();
            LocalDateTime prijava = entry.getValue();
            LocalDateTime odjava = odjaveTrenera.get(trener);

            JsonObject prijavaJson = new JsonObject();
            prijavaJson.addProperty("trener", trener.toString());
            prijavaJson.addProperty("datumVreme", prijava.format(FORMAT));
            prijaveJsonArray.add(prijavaJson);

            if (odjava != null) {
                JsonObject odjavaJson = new JsonObject();
                odjavaJson.addProperty("trener", trener.toString());
                odjavaJson.addProperty("datumVreme", odjava.format(FORMAT));
                odjaveJsonArray.add(odjavaJson);
            }
        }

        jsonReport.add("prijaveTrenera", prijaveJsonArray);
        jsonReport.add("odjaveTrenera", odjaveJsonArray);
    }

    private static void writeToAFile(JsonObject jsonReport) {
        try (FileWriter out = new FileWriter("izvestaj.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            out.write(gson.toJson(jsonReport));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setPrijaveTrenera(Map<Trener, LocalDateTime> prijaveTrenera) {
        JsonReport.prijaveTrenera = prijaveTrenera;
    }

    public static void setOdjaveTrenera(Map<Trener, LocalDateTime> odjaveTrenera) {
        JsonReport.odjaveTrenera = odjaveTrenera;
    }
}
