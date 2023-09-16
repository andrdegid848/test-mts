package com.mts.testmts.http.controller;

import com.mts.testmts.database.entity.Tariff;
import com.mts.testmts.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tariffs")
public class TariffController {

    private final TariffService tariffService;

    @GetMapping
    public String getTariffs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Page<Tariff> tariffPage = tariffService.findAll(PageRequest.of(page, size));
        model.addAttribute("tariffPage", tariffPage);
        return "tariff/parse";
    }

    @PostMapping
    public String parseTariffs() {
        tariffService.update();
        return "redirect:/tariffs";
    }
}
