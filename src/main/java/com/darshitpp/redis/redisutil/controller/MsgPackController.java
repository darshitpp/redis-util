package com.darshitpp.redis.redisutil.controller;

import com.darshitpp.redis.redisutil.domain.User;
import com.darshitpp.redis.redisutil.service.MsgPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msgPack")
public class MsgPackController {

    private final MsgPackService msgPackService;

    @Autowired
    public MsgPackController(MsgPackService msgPackService) {
        this.msgPackService = msgPackService;
    }

    @GetMapping("/get")
    public User get(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return msgPackService.get(firstName, lastName);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        msgPackService.put(user);
    }

    @PostMapping("/insertBulk")
    public void insertBulk(@RequestBody List<User> users) {
        for (User user : users) {
            msgPackService.put(user);
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("firstName") String firstName) {
        msgPackService.delete(firstName);
    }
}
