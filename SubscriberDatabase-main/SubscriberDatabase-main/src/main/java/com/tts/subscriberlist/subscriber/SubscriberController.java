package com.tts.subscriberlist.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubscriberController {

    @Autowired
    SubscriberRepository subscriberRepository;

    @GetMapping(value="/")
    public String index(Subscriber subscriber) {
        return "subscriber/index";
    }

    public Subscriber subscriber;
    @PostMapping(value = "/")
    public String addNewSubscriber(Subscriber subscriber, Model model) {
        subscriberRepository.save(new Subscriber(subscriber.getFirstName(),
                subscriber.getLastName(), subscriber.getUserName(),
                subscriber.getSignedUp()));
        model.addAttribute("firstName", subscriber.getFirstName());
        model.addAttribute("lastName", subscriber.getLastName());
        model.addAttribute("userName", subscriber.getUserName());
        model.addAttribute("id", subscriber.getId());
        return "subscriber/result";
    }

    @GetMapping(value="/showSubscribers")
    public String getSubscribers(Model model, String keyword) {
        List<Subscriber> subscriberList = (List<Subscriber>) subscriberRepository.findAll();

        model.addAttribute("subscribers", subscriberList);

        return"subscriber/AllSubscribers";
    }












}
