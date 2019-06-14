package com.titrate.todos.service;

// required by auditing service that weve been using

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

// ^ this is in charge of getting the current user (also see the likes 21-29

@Component
public class UserAuditing implements AuditorAware<String>
{

    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
        {
            uname = authentication.getName();
        }
        else
        {
            uname = "SYSTEM";
        }
        return Optional.of(uname);
    }

}