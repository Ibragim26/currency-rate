package ru.ibra.bot.processors;

import ru.ibra.bot.model.MessageTextProcessorResult;

public interface MessageTextProcessor {
    MessageTextProcessorResult process(String msgText);
}