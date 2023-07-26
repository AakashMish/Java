package org.aakmishr.course_api.database.topic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Topic {
    String name;
    @Id
    String id;
    String description;
}
