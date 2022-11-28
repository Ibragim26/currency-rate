package ru.Ibra.cbrrate.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.Ibra.cbrrate.clients.RateClient;
import ru.Ibra.cbrrate.model.CurrencyRate;
import ru.Ibra.cbrrate.model.RateType;

import java.time.LocalDate;
import java.util.Map;

@Service
@Slf4j
public class CurrencyRateEndpointService {
    //он сам будет понимать из какого источника тянуть данные по аннотации в Service и в енамке вместо if/switch
    private final Map<String, RateClient> clients;

    public CurrencyRateEndpointService(Map<String, RateClient> clients) {
        this.clients = clients;
    }

    public CurrencyRate getCurrencyRate(RateType rateType, String currency, LocalDate date) {
        log.info("getCurrencyRate. rateType:{}, currency:{}, date:{}", rateType, currency, date);
        RateClient client = clients.get(rateType.getServiceName());;
        return client.getCurrencyRate(currency, date);
    }
}