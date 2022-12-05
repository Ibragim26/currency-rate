package ru.ibra.bot.client;

public interface HttpClient {

    String performRequest(String url, String params);
    String performRequest(String url);

}
