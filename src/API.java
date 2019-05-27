import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class API {
    void api() {
        try {
            URL url = new URL(EndPoints.end_point);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("api-key", EndPoints.end_point_key);
            httpURLConnection.setRequestMethod(EndPoints.get_method);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            //get responseCode here
            int responseCode = httpURLConnection.getResponseCode();
            //check the responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                //loop the response contents here
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                httpURLConnection.disconnect();


                //pass the messages to the queue here
                new MyListener().listen(response.toString());
            } else {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
