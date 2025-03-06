package pl.cloud.crudmig;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
class CompetitorMockData {

    private final static Set<CompetitorViewDTO> initialsCompetitorsMockData;

    static {
        initialsCompetitorsMockData = createMockCompetitorsData();
    }

    private CompetitorMockData() {
    }

    public static Set<CompetitorViewDTO> findAllCompetitors() {
        return initialsCompetitorsMockData;
    }

    public static Optional<CompetitorViewDTO> findCompetitorById(long id) {
        return initialsCompetitorsMockData.stream()
                .filter(competitor -> competitor.getId() == id)
                .findFirst();
    }

    private static Set<CompetitorViewDTO> createMockCompetitorsData() {
        Set<CompetitorViewDTO> mockCompetitorsData = new HashSet<>();
        mockCompetitorsData.add(new CompetitorViewDTO(1L, "Jan", "Paweł II", "KuriaFuria"));
        mockCompetitorsData.add(new CompetitorViewDTO(2L, "Adam", "Słodowy", "Blok mieszkalny"));
        return mockCompetitorsData;
    }
}
