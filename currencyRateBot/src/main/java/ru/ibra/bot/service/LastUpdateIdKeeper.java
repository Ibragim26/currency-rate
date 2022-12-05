package ru.ibra.bot.service;

public interface LastUpdateIdKeeper {
    long get();

    void set(long lastUpdateId);
}