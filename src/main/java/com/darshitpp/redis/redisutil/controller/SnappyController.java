package com.darshitpp.redis.redisutil.controller;

import com.darshitpp.redis.redisutil.domain.User;
import com.darshitpp.redis.redisutil.service.SnappyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snappy")
public class SnappyController {

    private final SnappyService snappyService;

    @Autowired
    public SnappyController(SnappyService snappyService) {
        this.snappyService = snappyService;
    }

    @GetMapping("/get")
    public User get(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return snappyService.get(firstName, lastName);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        snappyService.put(user);
    }

    @PostMapping("/insertBulk")
    public void insertBulk(@RequestBody List<User> users) {
        for (User user : users) {
            snappyService.put(user);
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("firstName") String firstName) {
        snappyService.delete(firstName);
    }
}
