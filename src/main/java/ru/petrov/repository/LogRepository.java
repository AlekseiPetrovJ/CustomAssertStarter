package ru.petrov.repository;

import ru.petrov.model.Log;
import ru.petrov.model.LogLevel;

import java.util.List;
import java.util.Optional;

public interface LogRepository {
    /**
     * @return empty Optional when write attempt fails
     */
    Optional<Log> save(Log log);

    /**
     * @return empty List when log not found by userName ordered by registration
     */
    List<Log> get(String userName);

    /**
     * @return empty List when log not found by userName and log level ordered by registration
     */
    List<Log> getByLevel(LogLevel level, String userName);
}
