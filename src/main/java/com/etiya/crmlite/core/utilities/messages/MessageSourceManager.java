package com.etiya.crmlite.core.utilities.messages;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageSourceManager implements IMessageSourceService{
    private MessageSource messageSource;

    @Override
    public String getMessage(String code) {
        return messageSource.getMessage(code,null, LocaleContextHolder.getLocale());
    }
}
