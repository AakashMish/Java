package org.aakmishr.course_api.database.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{topicName}")
    public Topic getTopic(@PathVariable String topicName) {
        return topicService.getTopicByName(topicName);
    }

    @RequestMapping(value = "/topics" , method = RequestMethod.POST)
    public String addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return "201 - Topic Created";
    }

    @RequestMapping(value = "/topics/{topicName}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String topicName) {
        topicService.updateTopic(topic, topicName);
    }

    @RequestMapping(value = "/topics/{topicName}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String topicName) {
        topicService.deleteTopic(topicName);
    }

}
