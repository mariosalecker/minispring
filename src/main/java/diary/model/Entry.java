package diary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Entry {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String entry;

    private LocalDate date;

    @ManyToOne
    private Diary diary;

    // implement equals and hashcode
}
