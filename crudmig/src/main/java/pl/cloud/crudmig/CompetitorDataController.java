package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/")
public class CompetitorDataController {

    private final CompetitorService competitorService;

    public CompetitorDataController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @PostMapping("/createCompetitor")
    public ResponseEntity<Void> createCompetitor(@RequestBody CompetitorDTO competitor) {
        competitorService.createCompetitor(competitor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/removeCompetitors")
    public ResponseEntity<Void> removeCompetitors(@RequestBody Set<Long> competitorIds) {
        competitorService.removeCompetitorsByIds(competitorIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
