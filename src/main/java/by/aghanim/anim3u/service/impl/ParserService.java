package by.aghanim.anim3u.service.impl;

import by.aghanim.anim3u.exceptions.InvalidInputException;
import by.aghanim.anim3u.service.api.IParserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;

public class ParserService implements IParserService {
    private static final String M3U8_FILE_STRUCTURE = """
                            \n#EXTINF:0 type="video" channelId="-1" group="Anime" logo="https://anilibria.tv/%s" size="Medium" background="#9d61f8", %s Ep. %s
                            https://cache.libria.fun/%s""";

    @Override
    public void save(URL url) throws InvalidInputException {
        String output = "#EXTM3U";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode root = objectMapper.readTree(url);

            if (root.path("list").isEmpty()) {
                throw new InvalidInputException("No such title!");
            }

            JsonNode list = root.path("list").get(0);
            JsonNode episodesNode = list.path("player").path("list");
            Iterator<JsonNode> elements = episodesNode.elements();
            String title = list.path("names").path("en").asText();
            String logo = list.path("posters").path("small").path("url").asText();
            int episodeNumber = 1;

            while(elements.hasNext()) {
                JsonNode episode = elements.next();

                if (episode.path("hls").path("fhd").isNull()) {
                    String link = episode.path("hls").path("hd").asText();

                    output = output.concat(String.format(M3U8_FILE_STRUCTURE, logo, title, episodeNumber, link));
                } else {
                    String link = episode.path("hls").path("fhd").asText();

                    output = output.concat(String.format(M3U8_FILE_STRUCTURE, logo, title, episodeNumber, link));
                }

                episodeNumber++;
            }

            try (Writer out = new FileWriter("%s.m3u".formatted(
                    title.replaceAll("[\\\\/:*?\"<>|]", "")), false)) {
                out.write(output);
            }
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
