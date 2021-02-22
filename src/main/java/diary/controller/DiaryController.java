package diary.controller;

import diary.model.Diary;
import diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryRepository diaryRepository;

    // what methods would you provide?
    // How would you implement pagination
    // how to implement query functionality?
    @GetMapping
    public ResponseEntity<List<Diary>> getMyDiaries() {
        return ResponseEntity.ok(diaryRepository.findAll());
    }
}


