package ru.petrov.model;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Log {
    private final LocalDateTime registered;
    private final LogLevel level;
    private final String userName;
    private final String logValue;
    private final long duration;


    public Log(LocalDateTime registered, LogLevel level, String userName, String logValue, long duration) {
        this.registered = registered;
        this.level = level;
        this.userName = userName;
        this.logValue = logValue;
        this.duration = duration;
    }

    public Log(LogLevel level, String userName, String logValue) {
        this(LocalDateTime.now(), level, userName, logValue, 0);
    }

    public Log(LogLevel level, String userName, String logValue, long duration) {
        this(LocalDateTime.now(), level, userName, logValue, duration);
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getUserName() {
        return userName;
    }

    public String getLogValue() {
        return logValue;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Log) obj;
        return Objects.equals(this.registered, that.registered) &&
                Objects.equals(this.level, that.level) &&
                Objects.equals(this.userName, that.userName) &&
                Objects.equals(this.logValue, that.logValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registered, level, userName, logValue);
    }

    @Override
    public String toString() {
        return "Log[" +
                "dateTime=" + registered + ", " +
                "duration=" + duration + "ms, " +
                "level=" + level + ", " +
                "user=" + userName + ", " +
                "log=" + logValue + ']';
    }
}