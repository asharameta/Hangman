package src;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

///word api that can be used
///https://random-word-api.herokuapp.com/home
///https://www.datamuse.com/api/

public class Dictionary {
	private final String wordUri = "https://random-word-api.herokuapp.com/word";
	
	public Dictionary() {}
	
	public CompletableFuture<String> getAsyncRandomWord() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wordUri))
                .build();
        
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
	}
	
	public String getSyncRandomWord() {
        String result = "";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wordUri))
                .build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            result = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
