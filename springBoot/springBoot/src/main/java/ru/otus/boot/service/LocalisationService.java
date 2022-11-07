package ru.otus.boot.service;

public interface LocalisationService {

    String getLocaleMessage(String bundleName, Object[] args);
}
