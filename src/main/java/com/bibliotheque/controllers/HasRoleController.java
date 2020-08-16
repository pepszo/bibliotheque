package com.bibliotheque.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class HasRoleController {
    @RequestMapping(value = "/ur", method = RequestMethod.GET)
    @ResponseBody
    public Collection<? extends GrantedAuthority> currentUserName(Authentication principal) {

        return principal.getAuthorities();
    }
}
