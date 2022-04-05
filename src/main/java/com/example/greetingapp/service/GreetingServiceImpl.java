package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService{
    @Autowired
    private GreetingRepository greetingRepository;

    private static final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template,(user.toString().isEmpty())? "Hello World" :user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }
}
