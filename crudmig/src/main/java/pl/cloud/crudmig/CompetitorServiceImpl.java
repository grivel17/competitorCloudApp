package pl.cloud.crudmig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompetitorServiceImpl implements CompetitorService {
    private static final Logger loggerInfo = LoggerFactory.getLogger(CrudmigApplication.class);
    @Override
    public void createCompetitor(CompetitorDTO competitorDTO) {
        loggerInfo.info("Metoda została wywołana! "+ "Name " + competitorDTO.getName() + " Klub " + competitorDTO.getClubName());
    }
}
