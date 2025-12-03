package pl.cloud.crudmig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CompetitorServiceImpl implements CompetitorService {

    private final CompetitorMockData competitorMockData;
    private static final Logger loggerInfo = LoggerFactory.getLogger(CrudmigApplication.class);
    private final CompetitorValidator competitorValidator;

    public CompetitorServiceImpl(CompetitorValidator competitorValidator, CompetitorMockData competitorMockData) {
        this.competitorValidator = competitorValidator;
        this.competitorMockData = competitorMockData;
    }

    @Override
    public void createCompetitor(CompetitorDTO competitorDTO) {
        competitorValidator.validateCompetitor(competitorDTO);
        loggerInfo.info("Metoda została wywołana! " + "Name " + competitorDTO.getName() + " Klub " + competitorDTO.getClubName());
    }

    @Override
    public void removeCompetitorsByIds(Set<Long> competitorIds) {
        if (!allCompetitorsToRemoveExist(competitorIds)) {
            throw new CompetitorNotFoundException("Nie możemy skasować nieisniejącego zawodnika");
        }
        loggerInfo.info("Udało się skasować zawodników o numerach: " + competitorIds.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private boolean allCompetitorsToRemoveExist(Set<Long> competitorIds) {
        return CompetitorMockData.findAllCompetitors().stream()
                .map(CompetitorViewDTO::getId)
                .collect(Collectors.toSet())
                .containsAll(competitorIds);
    }
}
