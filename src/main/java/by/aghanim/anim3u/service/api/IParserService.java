package by.aghanim.anim3u.service.api;

import by.aghanim.anim3u.exceptions.InvalidInputException;

import java.net.URL;

public interface IParserService {
    void save(URL url) throws InvalidInputException;
}
