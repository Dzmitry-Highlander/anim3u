package by.aghanim.anim3u.service.api;

import by.aghanim.anim3u.exceptions.InvalidInputException;

import java.net.URL;

public interface IURLService {
    URL get(String title) throws InvalidInputException;
}
