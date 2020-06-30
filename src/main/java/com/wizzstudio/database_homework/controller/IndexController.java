package com.wizzstudio.database_homework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("")
    public String index() {
        return "This is database homework backend , by Qht :D";
    }
}
