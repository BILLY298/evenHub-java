package Service;

import DB.Coneccion;
import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.io.FileNotFoundException;
import java.util.Map.Entry;

public class jsontoConeccion {
    private static boolean host = false;
    private static boolean port = false;
    private static boolean user = false;
    private static boolean pass = false;
    private static boolean bd = false;
    private static Coneccion con = null;

    public static Coneccion getCon() throws FileNotFoundException {
        if (con==null){
            con = new Coneccion();
            JsonParser parser = new JsonParser();
            FileReader fr = new FileReader("C:\\Users\\valde\\Documents\\GitHub\\evenHub-java\\src\\main\\java\\DB\\databases.json");
            JsonElement datos = parser.parse(fr);
            readJson(datos);
            
        }
        return con;
    }
    

    public static void readJson(JsonElement elemento) {
        if (elemento.isJsonObject()) {
            JsonObject obj = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String, JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String, JsonElement>> iter = entradas.iterator();
            while (iter.hasNext()) {
                java.util.Map.Entry<String, JsonElement> entrada = iter.next();
                if(entrada.getKey().equals("host")){
                    host = true;
                    port = false;user = false;pass = false;bd = false;
                }else if(entrada.getKey().equals("port")){
                    port = true;
                    host = false;user = false;pass = false;bd = false;
                }else if(entrada.getKey().equals("user")){
                    user = true;
                    host = false;port = false;pass = false;bd = false;
                }else if(entrada.getKey().equals("pass")){
                    pass = true;
                    host = false;port = false;user = false;bd = false;
                }else if(entrada.getKey().equals("bd")){
                    bd = true;
                    host = false;port = false;user = false;pass=false;
                }
                readJson(entrada.getValue());
            }
        } else if (elemento.isJsonArray()) {
            JsonArray array = elemento.getAsJsonArray();
            java.util.Iterator<JsonElement> iter = array.iterator();
            while (iter.hasNext()) {
                JsonElement entrada = iter.next();
                readJson(entrada);
            }
        } else if (elemento.isJsonPrimitive()) {
            JsonPrimitive valor = elemento.getAsJsonPrimitive();
            if(host)
                con.setHost(valor.getAsString());
            if(port)
                con.setPort(valor.getAsString());
            if(user)
                con.setUser(valor.getAsString());
            if(pass)
                con.setPassword(valor.getAsString());
            if(bd)
                con.setBasedatos(valor.getAsString());
        }
    }

}
