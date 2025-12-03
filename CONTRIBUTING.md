# Wytyczne dla Kontrybutorów

Dziękujemy za zainteresowanie projektem **Competitor Cloud App**! 🎉

Ten dokument zawiera wytyczne dotyczące współpracy przy rozwoju projektu.

## 📋 Spis Treści

- [Kodeks Postępowania](#kodeks-postępowania)
- [Jak mogę pomóc?](#jak-mogę-pomóc)
- [Proces rozwoju](#proces-rozwoju)
- [Standardy kodowania](#standardy-kodowania)
- [Proces Pull Request](#proces-pull-request)
- [Raportowanie błędów](#raportowanie-błędów)
- [Sugestie funkcjonalności](#sugestie-funkcjonalności)

## 📜 Kodeks Postępowania

### Nasze zasady:
- 🤝 Szanuj innych uczestników projektu
- 💬 Konstruktywna krytyka jest mile widziana
- 🚫 Zero tolerancji dla dyskryminacji, nękania i obraźliwego zachowania
- 🌍 Wspieramy otwartą i przyjazną społeczność

## 🤔 Jak mogę pomóc?

Projekt jest w fazie wczesnego rozwoju, więc każda pomoc jest cenna!

### Sposoby współpracy:

#### 1. 📝 Dokumentacja
- Udoskonalanie README i dokumentacji technicznej
- Tłumaczenia na inne języki
- Tworzenie tutoriali i przykładów użycia
- Poprawianie literówek i błędów gramatycznych

#### 2. 💻 Kod
- Implementacja nowych funkcjonalności
- Refaktoryzacja istniejącego kodu
- Optymalizacja wydajności
- Pisanie testów jednostkowych i integracyjnych

#### 3. 🐛 Testing & QA
- Testowanie aplikacji
- Raportowanie błędów
- Weryfikacja Pull Requestów
- Tworzenie test cases

#### 4. 🎨 Design & UX
- Projektowanie interfejsu użytkownika
- Tworzenie mockupów i prototypów
- User experience research
- Grafiki i ikony

#### 5. 🏗️ DevOps & Infrastructure
- Setup CI/CD pipelines
- Konfiguracja containerów
- Monitoring i logging
- Infrastructure as Code

## 🔄 Proces Rozwoju

### Workflow Git

Używamy **GitHub Flow** - prostego i efektywnego workflow:

```
main (protected)
  │
  ├─ feature/nazwa-funkcji
  ├─ bugfix/nazwa-bledu
  ├─ hotfix/nazwa-krytycznego-bledu
  └─ docs/nazwa-dokumentu
```

### Konwencja nazewnictwa branchy:

```bash
feature/login-authentication      # Nowa funkcjonalność
bugfix/fix-null-pointer          # Naprawa błędu
hotfix/critical-security-patch   # Krytyczna poprawka
docs/update-readme               # Dokumentacja
refactor/optimize-database       # Refaktoryzacja
test/add-unit-tests             # Dodanie testów
```

### Kroki procesu:

1. **Fork** repozytorium
2. **Clone** swojego forka lokalnie
3. **Stwórz branch** z odpowiednią nazwą
4. **Implementuj** zmiany
5. **Testuj** dokładnie swoje zmiany
6. **Commit** z jasnym opisem
7. **Push** do swojego forka
8. **Otwórz Pull Request** z opisem zmian

## 💻 Standardy Kodowania

### Java Code Style

Przestrzegamy **Google Java Style Guide** z drobnymi modyfikacjami:

#### Formatowanie:
```java
// ✅ DOBRZE
public class UserService {
    private static final int MAX_RETRY = 3;
    
    public User findUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }
}

// ❌ ŹLE
public class UserService{
  private static final int MAX_RETRY=3;
  
  public User findUser(Long id){
    if(id==null) throw new IllegalArgumentException("ID cannot be null");
    return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
  }
}
```

#### Konwencje nazewnictwa:
```java
// Klasy: PascalCase
public class CompetitorAnalysisService { }

// Metody i zmienne: camelCase
private String userName;
public void calculatePrice() { }

// Stałe: UPPER_SNAKE_CASE
public static final int MAX_CONNECTIONS = 100;

// Package: lowercase
package com.competitor.analysis.service;
```

#### Najlepsze praktyki:

1. **Single Responsibility Principle**
   ```java
   // ✅ Jedna odpowiedzialność
   public class PriceCalculator {
       public BigDecimal calculate(Product product) { ... }
   }
   
   // ❌ Zbyt wiele odpowiedzialności
   public class PriceCalculator {
       public BigDecimal calculate(Product product) { ... }
       public void saveToDatabase(Price price) { ... }
       public void sendEmail(User user) { ... }
   }
   ```

2. **Meaningful Names**
   ```java
   // ✅ Opisowe nazwy
   public List<Product> findProductsByCategory(String categoryName) { }
   
   // ❌ Niejasne nazwy
   public List<Product> find(String s) { }
   ```

3. **Dokumentacja JavaDoc** dla public API
   ```java
   /**
    * Calculates the total price including tax.
    *
    * @param basePrice the base price without tax
    * @param taxRate the tax rate as a decimal (e.g., 0.23 for 23%)
    * @return the total price with tax applied
    * @throws IllegalArgumentException if basePrice is negative
    */
   public BigDecimal calculateTotalPrice(BigDecimal basePrice, double taxRate) {
       // implementation
   }
   ```

4. **Obsługa wyjątków**
   ```java
   // ✅ Specyficzne wyjątki
   catch (FileNotFoundException e) {
       log.error("Configuration file not found", e);
       throw new ConfigurationException("Cannot load config", e);
   }
   
   // ❌ Łapanie wszystkiego
   catch (Exception e) {
       // bad practice
   }
   ```

### Testing Standards

#### Unit Tests:
```java
@Test
@DisplayName("Should calculate correct price with tax")
void shouldCalculateCorrectPriceWithTax() {
    // Given
    BigDecimal basePrice = new BigDecimal("100.00");
    double taxRate = 0.23;
    
    // When
    BigDecimal result = priceCalculator.calculateTotalPrice(basePrice, taxRate);
    
    // Then
    assertThat(result).isEqualByComparingTo("123.00");
}
```

#### Code Coverage:
- Minimum: **80%** dla nowego kodu
- Cel: **90%+** dla core business logic

### Commit Messages

Używamy **Conventional Commits**:

```
<type>(<scope>): <subject>

<body>

<footer>
```

#### Typy commitów:
- `feat`: Nowa funkcjonalność
- `fix`: Naprawa błędu
- `docs`: Zmiany w dokumentacji
- `style`: Formatowanie, brakujące średniki, etc.
- `refactor`: Refaktoryzacja kodu
- `test`: Dodanie lub modyfikacja testów
- `chore`: Zmiany w procesie budowania, dependencies, etc.

#### Przykłady:
```bash
feat(auth): add JWT token authentication

Implemented JWT-based authentication system with refresh tokens.
Includes middleware for token validation.

Closes #123

---

fix(api): resolve null pointer in user service

Fixed NPE when user not found in database.
Added proper null checks and exception handling.

Fixes #456

---

docs(readme): update installation instructions

Added missing step for database setup.
```

## 🔀 Proces Pull Request

### Przed utworzeniem PR:

- [ ] Kod jest zgodny ze standardami projektu
- [ ] Wszystkie testy przechodzą lokalnie
- [ ] Dodano nowe testy dla nowej funkcjonalności
- [ ] Dokumentacja została zaktualizowana (jeśli potrzeba)
- [ ] Commit messages są zgodne z konwencją
- [ ] Branch jest aktualny z `main`

### Template Pull Request:

```markdown
## Opis
Krótki opis wprowadzonych zmian.

## Typ zmian
- [ ] Bug fix (non-breaking change)
- [ ] New feature (non-breaking change)
- [ ] Breaking change (fix lub feature)
- [ ] Documentation update

## Jak przetestować?
Kroki do weryfikacji zmian:
1. ...
2. ...

## Checklist:
- [ ] Kod przechodzi linting
- [ ] Testy przechodzą lokalnie
- [ ] Dodano/zaktualizowano testy
- [ ] Dokumentacja zaktualizowana
- [ ] Brak konfliktów z main
```

### Code Review Process:

1. **Automatyczne sprawdzenia**
   - CI/CD pipeline musi przejść
   - Code quality checks (SonarQube)
   - Security scanning

2. **Manual review**
   - Minimum 1 approver wymagany
   - Odpowiedź na feedback w ciągu 48h

3. **Merge**
   - Squash and merge (dla małych PR)
   - Rebase and merge (dla większych PR)

## 🐛 Raportowanie Błędów

### Przed zgłoszeniem:

1. Sprawdź czy błąd nie był już zgłoszony
2. Sprawdź czy nie jest to znany problem
3. Upewnij się że używasz najnowszej wersji

### Template zgłoszenia błędu:

```markdown
**Opis błędu:**
Jasny i zwięzły opis problemu.

**Kroki do reprodukcji:**
1. Przejdź do '...'
2. Kliknij na '...'
3. Przewiń do '...'
4. Zobacz błąd

**Oczekiwane zachowanie:**
Co powinno się stać.

**Aktualne zachowanie:**
Co się faktycznie dzieje.

**Screenshots:**
Jeśli możliwe, dodaj screenshoty.

**Środowisko:**
- OS: [e.g. Ubuntu 22.04]
- Java Version: [e.g. 17]
- App Version: [e.g. 1.2.3]

**Dodatkowy kontekst:**
Wszelkie inne informacje o problemie.
```

## 💡 Sugestie Funkcjonalności

Masz pomysł na nową funkcjonalność? Świetnie!

### Template sugestii:

```markdown
**Czy to rozwiązuje jakiś problem?**
Jasny opis problemu. Ex. Frustruje mnie że [...]

**Opisz preferowane rozwiązanie:**
Co chciałbyś zobaczyć.

**Alternatywy:**
Inne rozwiązania które rozważałeś.

**Dodatkowy kontekst:**
Screenshots, mockupy, etc.
```

## 🏷️ Labels

Używamy następujących labeli:

- `bug` - Coś nie działa
- `enhancement` - Nowa funkcjonalność
- `documentation` - Dokumentacja
- `good first issue` - Dobry dla początkujących
- `help wanted` - Potrzebna pomoc
- `priority: high` - Wysoki priorytet
- `priority: low` - Niski priorytet
- `wontfix` - Nie będzie naprawiane

## 📞 Kontakt

Pytania? Skontaktuj się:

- Otwórz issue z pytaniem
- Napisz do maintainera: [@grivel17](https://github.com/grivel17)

## 🙏 Podziękowania

Dziękujemy wszystkim kontrybutorów za wkład w projekt!

---

**Happy Coding! 🚀**
