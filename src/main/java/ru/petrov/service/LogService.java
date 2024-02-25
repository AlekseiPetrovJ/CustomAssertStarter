package ru.petrov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.petrov.model.Log;
import ru.petrov.repository.LogRepository;

import java.util.Optional;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Optional<Log> save(Log log) {
        if (log.getUserName() == null) {
            return logRepository.save(new Log(log.getRegistered(), log.getLevel(), "anonymousUser", log.getLogValue(), log.getDuration()));
        }
        return logRepository.save(log);
    }
}