package com.darshitpp.redis.redisutil.controller;

import com.darshitpp.redis.redisutil.domain.User;
import com.darshitpp.redis.redisutil.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/normal")
public class NormalController {

    private final NormalService normalService;

    @Autowired
    public NormalController(NormalService normalService) {
        this.normalService = normalService;
    }

    @GetMapping("/get")
    public User get(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return normalService.get(firstName, lastName);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        normalService.put(user);
    }

    @PostMapping("/insertBulk")
    public void insertBulk(@RequestBody List<User> users) {
        for (User user : users) {
            normalService.put(user);
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("firstName") String firstName) {
        normalService.delete(firstName);
    }
}
