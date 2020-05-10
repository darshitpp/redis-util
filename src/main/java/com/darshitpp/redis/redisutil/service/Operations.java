package com.darshitpp.redis.redisutil.service;

import com.darshitpp.redis.redisutil.domain.User;

public interface Operations {
    User get(String firstName, String lastName);
    void put(User user);
    void delete(String firstName);
}
