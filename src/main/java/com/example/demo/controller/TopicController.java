package com.example.demo.controller;

import com.example.demo.classes.Topic;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/topics")
public class TopicController {

    @Autowired
    private static TopicService topicService;


    @GetMapping
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopics();

    }
    @GetMapping(path = "{id}")
    public Topic getTopic(@PathVariable("id")String id)
    {
        return topicService.getTopic(id);
    }
    @PostMapping
    public void addNewTopic(@RequestBody Topic topic)
    {
        topicService.addNewTopic(topic);
    }
    @PutMapping(path = "{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable("id")String id)
    {
        topicService.updateTopic(topic,id);
    }

    @DeleteMapping (path = "{id}")
    public void deleteTopic(@PathVariable("id")String id)
    {
        topicService.deleteTopic(id);
    }


}
