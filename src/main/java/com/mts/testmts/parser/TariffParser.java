package com.mts.testmts.parser;

import com.mts.testmts.database.entity.Tariff;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TariffParser {
    private final String URL = "https://moskva.mts.ru/personal/mobilnaya-svyaz/tarifi/vse-tarifi/mobile-tv-inet";

    public List<Tariff> parse() {
        List<Tariff> tariffs = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();

            Elements tariffElements = doc.select(".card.card__wrapper");

            for (Element tariffElement : tariffElements) {
                String cardTitle = tariffElement.select(".card-title.card-title__margin").text();
                String cardDescription = tariffElement.select(".card-description").text();

                String priceText = tariffElement.select(".price-text").text();
                String[] priceParts = priceText.split("\\s+");
                Integer price = Integer.parseInt(priceParts[0]);

                tariffs.add(Tariff.builder()
                        .title(cardTitle)
                        .description(cardDescription)
                        .price(price)
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tariffs;
    }
}
