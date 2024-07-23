package com.sp.splunkintegration.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {


    Logger LOGGER = LogManager.getLogger(PageController.class);

    @GetMapping("/")
    public String getIndex(){
        LOGGER.info("getIndex, You got here.");
        return "Hello World";
    }

    @GetMapping("/getLogs")
    public String getLogs(){
        LOGGER.info("getLogs: {}", System.currentTimeMillis());
        LOGGER.info("getLogs: {}", "Some awesome logs.");
        LOGGER.info("getLogs: {}", "Some meaningful logs.");
        return "You got logs!";
    }
}
