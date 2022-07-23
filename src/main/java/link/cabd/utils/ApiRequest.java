package link.cabd.utils;


import com.google.gson.Gson;
import link.cabd.entity.Title;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiRequest {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void sendPost(List<Title> data) throws Exception {
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
            .uri(URI.create("https://58va70upr4.execute-api.us-east-1.amazonaws.com/main/titles"))
            .setHeader("User-Agent", "Java 11 HttpClient Bot")
            .header("Content-Type", "application/json")
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
