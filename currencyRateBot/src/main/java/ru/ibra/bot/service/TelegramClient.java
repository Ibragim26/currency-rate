package ru.ibra.bot.service;

import ru.ibra.bot.model.GetUpdatesRequest;
import ru.ibra.bot.model.GetUpdatesResponse;
import ru.ibra.bot.model.SendMessageRequest;

public interface TelegramClient {
    GetUpdatesResponse getUpdates(GetUpdatesRequest request);

    void sendMessage(SendMessageRequest request);
}
