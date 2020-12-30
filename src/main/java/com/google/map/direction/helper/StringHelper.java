package com.google.map.direction.helper;

import org.jsoup.Jsoup;

import java.util.List;

import static java.util.Arrays.stream;

/**
 * Created By Ponir on 29December,2020.
 */
public class StringHelper {
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    public static Double totalDistance(List<Long> distances) {
        return (stream(distances.stream().mapToLong(l -> l).toArray()).sum() * 0.001);
    }

    public static Long totalDuration(List<Long> durations) {
        long duration = stream(durations.stream().mapToLong(l -> l).toArray()).sum();
        return (duration % 3600) / 60;
    }

    public static String averagedSpeedCalculate(Double distance, Long duration) {
        return (int) (distance / minToHour(duration)) + " km/hrs";
    }

    public static Double minToHour(Long duration) {
        return duration * 0.0166667;
    }
}
