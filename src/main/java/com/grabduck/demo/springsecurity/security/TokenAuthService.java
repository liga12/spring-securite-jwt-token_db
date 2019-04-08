package com.grabduck.demo.springsecurity.security;

import com.grabduck.demo.springsecurity.persistence.entity.User;
import com.grabduck.demo.springsecurity.services.TokenService;
import com.grabduck.demo.springsecurity.services.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenAuthService {
    private static final String AUTH_HEADER_NAME = "Authorization";

    private final TokenService tokenService;

    private final TokenHandler tokenHandler;

    private final UserServiceImpl userServiceImpl;

    public Optional<Authentication> getAuthentication(@NonNull HttpServletRequest request) {
        User authorities = User.builder().authorities(new ArrayList<>()).build();

        String tokenFromRequest = getTokenFromRequest(request);
        if (tokenFromRequest != null) {
            return Optional
                    .ofNullable(request.getHeader(getTokenFromRequest(request)))
                    .flatMap(tokenHandler::extractUserId)
                    .flatMap(userServiceImpl::findById)
                    .map(UserAuthentication::new);
        }
        return Optional.of(new UserAuthentication(authorities));
    }

    private String getTokenFromRequest(@NonNull HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTH_HEADER_NAME);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer") && authorizationHeader.length() == 153) {
            if (tokenService.getByToken(authorizationHeader.substring(7)) != null) {
                return authorizationHeader.substring(7);
            }
        }
        return null;
    }
}
