package ru.ibra.bot.client;

import ru.ibra.cbrrate.model.CurrencyRate;

import java.time.LocalDate;

public interface CurrencyRateClient {

    CurrencyRate getCurrencyRate(String rateType, String currency, LocalDate date);
}