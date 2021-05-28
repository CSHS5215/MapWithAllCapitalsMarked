package com.Kuza.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MapController {

    @Autowired
    private final CapitalsParser capitalsParser;

    public MapController(CapitalsParser capitalsParser) {
        this.capitalsParser = capitalsParser;
    }

    @GetMapping
    public String getMap(Model model) throws IOException {
        model.addAttribute("points", capitalsParser.getPoints());
        return "map";
    }
}


