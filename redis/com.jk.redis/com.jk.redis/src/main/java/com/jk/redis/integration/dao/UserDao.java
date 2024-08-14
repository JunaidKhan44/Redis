package com.jk.redis.integration.dao;


import com.jk.redis.integration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.util.Map;

/**
 * @author Junaid Khan
 *
 */

@Repository
public class UserDao {
    private static final String KEY = "USER";
    @Autowired
    private RedisTemplate<String, Object> template;

    public User save(User user) {
        template.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    public User get(String userId) {
        return (User) template.opsForHash().get(KEY, userId);
    }

    public Map<Object, Object> findAll() {
        return template.opsForHash().entries(KEY);
    }

    public void delete(String userId) {
        template.opsForHash().delete(KEY, userId);
    }

    public void update(String userId, User newUser) {
        template.opsForHash().put(KEY, userId, newUser);
    }

}
