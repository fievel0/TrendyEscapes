package com.trendy.excepcion;

public class DuplicatedDataException extends RuntimeException {
    public DuplicatedDataException(String s) {
        super(s);
    }
}
