package com.dh.serieservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "chapters")
public class Chapter {

    @Id
    private Integer id;
    private String name;
    private Integer number;
    private String urlStream;
}
