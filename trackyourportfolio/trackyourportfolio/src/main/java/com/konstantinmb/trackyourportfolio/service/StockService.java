package com.konstantinmb.trackyourportfolio.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.konstantinmb.trackyourportfolio.entities.User;
import com.konstantinmb.trackyourportfolio.event.UserPayload;
import com.konstantinmb.trackyourportfolio.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class StockService {

    private final UserRepository userRepo;

    public void exampleMethod(UserPayload userInfo) throws JsonProcessingException {
        log.info("The userInfoEvent has been received successfully!");
        userRepo.save(User.builder()
                .username(userInfo.getUsername())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .email(userInfo.getEmail())
                .currentBudget(userInfo.getCurrentBudget())
                .build());
        log.info("User with username: " + userInfo.getUsername() + " was saved successfully to DB!");
    }
}
