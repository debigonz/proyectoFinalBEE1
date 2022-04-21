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
@Document(collection = "series")
public class Serie {

    @Id
    private Integer id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
