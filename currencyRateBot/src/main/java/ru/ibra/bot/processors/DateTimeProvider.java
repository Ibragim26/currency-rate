package ru.ibra.bot.processors;

import java.time.LocalDateTime;

public interface DateTimeProvider {
    LocalDateTime get();
}