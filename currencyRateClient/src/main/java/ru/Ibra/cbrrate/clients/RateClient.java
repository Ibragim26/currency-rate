package ru.Ibra.cbrrate.clients;

import ru.Ibra.cbrrate.model.CurrencyRate;

import java.time.LocalDate;

public interface RateClient {

    CurrencyRate getCurrencyRate(String currency, LocalDate date);
}
