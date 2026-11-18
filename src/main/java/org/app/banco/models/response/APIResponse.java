package org.app.banco.models.response;

import java.time.LocalDateTime;

public class APIResponse <T> {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String error;
    private T data;

    public APIResponse(){}

    public APIResponse(LocalDateTime timestamp, int status, String message, String error, T data) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
