package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
