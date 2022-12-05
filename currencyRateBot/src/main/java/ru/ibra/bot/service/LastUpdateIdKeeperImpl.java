package ru.ibra.bot.service;

import org.springframework.stereotype.Component;

@Component
//    за счет этого бина мы вынесли в синглтон, он шарится во всем приложении если приложение будет запущено на нескольких инстансах, то не произойдет неконсистентного сотояния
public class LastUpdateIdKeeperImpl implements LastUpdateIdKeeper {


    private long lastUpdateId = 0;

    @Override
    public synchronized long get() {
        return lastUpdateId;
    }

    @Override
    public synchronized void set(long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }
}
