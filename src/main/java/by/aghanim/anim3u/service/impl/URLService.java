package by.aghanim.anim3u.service.impl;

import by.aghanim.anim3u.exceptions.InvalidInputException;
import by.aghanim.anim3u.service.api.IURLService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLService implements IURLService {
    private static final String SEARCH_LINK_GET = "http://api.anilibria.tv/v3/title/search?search=";

    public URL get(String title) throws InvalidInputException {
        URL url;

        title = title.replaceAll(" ", "+");

        try {
            url = new URI(SEARCH_LINK_GET + title).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new InvalidInputException(e.getMessage());
        }

        return url;
    }
}
