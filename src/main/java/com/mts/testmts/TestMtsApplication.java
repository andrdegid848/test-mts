package com.mts.testmts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.io.IOException;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TestMtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMtsApplication.class, args);
    }

}
