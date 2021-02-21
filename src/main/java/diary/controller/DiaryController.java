package diary.controller;

import diary.model.Diary;
import diary.model.Entry;
import diary.repository.DiaryRepository;
import diary.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryRepository diaryRepository;
    private final EntryRepository entryRepository;

    // what methods would you provide?
    // How would you implement pagination
    // how to implement query functionality?
    @GetMapping
    public ResponseEntity<List<Diary>> getMyDiaries() {
        return ResponseEntity.ok(diaryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiary(@PathVariable("id") Long id) {
        Optional<Diary> byId = diaryRepository.findById(id);
        return byId.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/new")
    public ResponseEntity<Long> newDiary(@RequestBody Diary diary) {
        Diary saved = diaryRepository.save(diary);
        return ResponseEntity.ok(saved.getId());
    }

    @GetMapping("/{diary-id}/entry/{entry-id}")
    public ResponseEntity<Entry> getEntry(@PathVariable("diary-id") Long diaryId, @PathVariable("entry-id") Long entryId) {
        Optional<Diary> byId = diaryRepository.findById(diaryId);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Entry> entry = byId.get().getEntryList().stream().filter(e -> Objects.equals(e.getId(), entryId)).findFirst();
        return entry.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{diary-id}/entry/new")
    public ResponseEntity<Long> newEntry(@PathVariable("diary-id") Long diaryId, @RequestBody Entry entry) {
        Optional<Diary> byId = diaryRepository.findById(diaryId);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Entry saved = entryRepository.save(entry);
        return ResponseEntity.ok(saved.getId());
    }
}
