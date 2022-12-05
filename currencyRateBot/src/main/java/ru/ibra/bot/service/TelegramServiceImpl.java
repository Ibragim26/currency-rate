package ru.ibra.bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.ibra.bot.model.GetUpdatesRequest;
import ru.ibra.bot.model.GetUpdatesResponse;
import ru.ibra.bot.model.SendMessageRequest;

@Slf4j
public class TelegramServiceImpl implements TelegramService{

    private final TelegramClient telegramClient;
    private final MessageTextProcessor processorGeneral;
    private final LastUpdateIdKeeper lastUpdateIdKeeper;

    public TelegramServiceImpl(TelegramClient telegramClient,
                               @Qualifier("messageTextProcessorGeneral") MessageTextProcessor messageTextProcessor,
                               LastUpdateIdKeeper lastUpdateIdKeeper) {
        this.telegramClient = telegramClient;
        this.processorGeneral = messageTextProcessor;
        this.lastUpdateIdKeeper = lastUpdateIdKeeper;
    }

    @Override
    public void getUpdates() {
        log.info("getUpdates begin");
        var offset = lastUpdateIdKeeper.get();
        var request = new GetUpdatesRequest(offset);
        var response = telegramClient.getUpdates(request);
        var lastUpdateId = processResponse(response);
        lastUpdateId = lastUpdateId == 0 ? offset : lastUpdateId + 1;
        lastUpdateIdKeeper.set(lastUpdateId);
        log.info("getUpdates end, lastUpdateId:{}", lastUpdateId);
    }

    private long processResponse(GetUpdatesResponse response) {
        log.info("response.getResult().size:{}", response.getResult().size());
        long lastUpdateId = 0;
        for(var responseMsg : response.getResult()) {
            lastUpdateId = Math.max(lastUpdateId, responseMsg.getUpdateId());
            processMessage(responseMsg.getMessage());
        }
        log.info("lastUpdateId:{}", lastUpdateId);
        return lastUpdateId;
    }

    private void processMessage(GetUpdatesResponse.Message message) {
        log.info("message:{}", message);

        var chatId = message.getChat().getId();
        var messageId = message.getMessageId();

        var result  = processorGeneral.process(message.getText());
        var replay = result.getFailReply() == null ? result.getOkReply() : result.getFailReply();
        var sendMessageRequest = new SendMessageRequest(chatId, replay, messageId);
        telegramClient.sendMessage(sendMessageRequest);
    }
}