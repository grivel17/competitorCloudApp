package pl.cloud.crudmig;

import java.util.Set;

public interface CompetitorService {
    void createCompetitor(CompetitorDTO competitorDTO);

    void removeCompetitorsByIds(Set<Long> competitorIds);
}
