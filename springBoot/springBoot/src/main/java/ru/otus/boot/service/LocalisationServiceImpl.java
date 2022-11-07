package ru.otus.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalisationServiceImpl implements LocalisationService {
    private final MessageSource messageSource;

    @Override
    public String getLocaleMessage(String bundleName, @Nullable Object[] args) {
        return messageSource.getMessage(bundleName, args, LocaleContextHolder.getLocale());
    }
}