package com.example.kakeboapi.exception;

public class KakeboNotFoundException extends RuntimeException {
    public KakeboNotFoundException(long id) {
        super("指定されたIDが見つかりません。" + id);
    }
}
