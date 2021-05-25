import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class NbrbCourse {
    public void getCourse(Model model) throws IOException {
        URL url = new URL("https://www.nbrb.by/api/exrates/rates/".concat(model.getCurrencyName().concat("?parammode=2")));

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result +=in.nextLine();
        }
        JSONObject jsonObject = new JSONObject(result);
        model.setCur_ID(jsonObject.getInt("Cur_ID"));
        model.setDate(jsonObject.getString("Date"));
        model.setCur_Abbreviation(jsonObject.getString("Cur_Abbreviation"));
        model.setCur_Scale(jsonObject.getInt("Cur_Scale"));
        model.setCur_Name(jsonObject.getString("Cur_Name"));
        model.setCur_OfficialRate(jsonObject.getDouble("Cur_OfficialRate"));
    }
}

