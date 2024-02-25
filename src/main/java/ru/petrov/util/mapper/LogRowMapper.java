package ru.petrov.util.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.petrov.model.Log;
import ru.petrov.model.LogLevel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LogRowMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        LocalDateTime registered = resultSet.getTimestamp("registered").toLocalDateTime();
        LogLevel level = Enum.valueOf(LogLevel.class, resultSet.getString("log_level"));
        String logValue = resultSet.getString("log_value");
        int userId = resultSet.getInt("person_id");
        String user = resultSet.getString("user_name");
        long duration = resultSet.getLong("duration");
        return new Log(registered, level, user, logValue, duration);
    }
}