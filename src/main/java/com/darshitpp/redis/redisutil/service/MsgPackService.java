package com.darshitpp.redis.redisutil.service;

import com.darshitpp.redis.redisutil.domain.User;
import com.darshitpp.redis.redisutil.serializer.RedisSerializationBuilder;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgPackService implements Operations{

    private final RedisTemplate<String, User> redisTemplate;
    private final HashOperations<String, String, User> hashOperations;

    public MsgPackService(LettuceConnectionFactory redisConnectionFactory) {
        this.redisTemplate = RedisSerializationBuilder.getMsgPackRedisTemplate(redisConnectionFactory, User.class);
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    @Override
    public User get(String firstName, String lastName) {
        return hashOperations.get(firstName, lastName);
    }

    @Override
    public void put(User user) {
        hashOperations.put(user.getFirstName(), user.getLastName(), user);
    }

    @Override
    public void delete(String firstName) {
        hashOperations.delete(firstName);
    }
}
