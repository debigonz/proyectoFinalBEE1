package com.dh.serieservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "seasons")
public class Season {

    @Id
    private Integer id;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
