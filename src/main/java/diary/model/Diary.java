package diary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Diary {

    // How to generate id values?
    // how to convert enumerations?
    // how to implement relationships
    // How to implement transactions
    // What locking mechanisms exist?

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<Entry> entryList = new ArrayList<>();
    // link to the entries
}
