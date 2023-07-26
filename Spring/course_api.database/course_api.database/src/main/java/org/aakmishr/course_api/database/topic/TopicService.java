package org.aakmishr.course_api.database.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> listOfTopics = new ArrayList<>(Arrays.asList(
            new Topic("java","1","Java Topic"),
            new Topic("JS","2","JS Topic"),
            new Topic("C","3","C Topic")
    ));

    protected List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    protected Topic getTopicByName(String name) {
        return listOfTopics.stream().filter( t -> t.getName().equalsIgnoreCase(name))
                .findFirst().orElse(new Topic ("null","null","null"));
    }

    protected void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String topicName) {
        for (int i=0; i<listOfTopics.size(); i++) {
            Topic t = listOfTopics.get(i);
            if(t.getName().equalsIgnoreCase(topicName)) {
                listOfTopics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String topicName) {
        listOfTopics.removeIf(t -> t.getName().equalsIgnoreCase(topicName));
    }
}
