package pl.cloud.crudmig;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CompetitorDataViewController {
    private final CompetitorReadOnlyService competitorReadOnlyService;

    public CompetitorDataViewController(CompetitorReadOnlyService competitorReadOnlyService) {
        this.competitorReadOnlyService = competitorReadOnlyService;
    }

    @GetMapping("competitor/{id}")
    public ResponseEntity<CompetitorViewDTO> getCompetitorByIdRest(@PathVariable long id) {
        return competitorReadOnlyService.getCompetitorResponseById(id);
    }
}
