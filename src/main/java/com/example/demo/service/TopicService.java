package com.example.demo.service;

import com.example.demo.classes.Topic;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {



    @Autowired
    private TopicRepository topicRepository;




    private List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring","springboot","springboot is fun"),
                new Topic("javascript","js","js is fun"),
                new Topic("node","nodejs","nodejs is fun")

        ));



    public List<Topic> getAllTopics()
    {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }
    public Topic getTopic(String id)
    {
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }
    public void addNewTopic(Topic topic)
    {
//        Optional<Topic> temp= Optional.of(topics.stream().filter(t -> t.getId().equals(topic.getId())).findFirst().get());
//        if(temp.isPresent())
//        {
//            throw new IllegalArgumentException("Id already exist");
//
//        }

            topicRepository.save(topic);


    }

    public void updateTopic(Topic topic, String id) {
        for(int i=0;i< topics.size();i++)
        {
            if(topics.get(i).getId().equals(id))
            {
                topics.set(i,topic);
                return;
            }


        }


    }

    public void deleteTopic(String id) {
//        for(int i=0;i< topics.size();i++)
//        {
//            if(topics.get(i).getId().equals(id))
//            {
//                topics.remove(i);
//                return;
//            }
//
//
//        }
        topics.removeIf(t->t.getId().equals(id));
    }
}
