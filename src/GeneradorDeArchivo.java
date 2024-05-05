import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public  void  guardarJson(Moneda monedaCambiada) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("conversion_result"+".json");
        escritura.write(gson.toJson(monedaCambiada));
        escritura.close();

    }

}