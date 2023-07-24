package rendra.prames.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JobDto {
    private UUID id;
    private String type;
    private String url;
    private LocalDate createdAt;
    private String company;
    private String companyUrl;
    private String location;
    private String title;
    private String description;
}
