
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://universities.hipolabs.com/search?country=United+States");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }



                //Close the scanner
                scanner.close();

                // Creating an instance of ObjectMapper class
                ObjectMapper objectMapper = new ObjectMapper();
                // Get tree representation of json
                JsonNode jsonTree = objectMapper.readTree(inline);


                for(int i=0;i<jsonTree.size();i++){
                    System.out.println(jsonTree.get(i).get("name").asText());
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

