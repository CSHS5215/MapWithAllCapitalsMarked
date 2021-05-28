package com.Kuza.Map;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CapitalsParser {

    public  List<Point> getPoints() throws IOException {

        String path = "src/main/resources/Files/capitals.csv";

        List<Point> points = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double lat = Double.parseDouble(values[2]);
                double lon = Double.parseDouble(values[3]);
                String text = values[0] + ", "+ values[1];
                points.add(new Point(lat,lon,text));
            }
        }


        return points;
    }

    public CapitalsParser() {
    }

}


