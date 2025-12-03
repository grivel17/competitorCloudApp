# Architektura Projektu - Competitor Cloud App

## 📁 Proponowana Struktura Katalogów

```
competitorCloudApp/
│
├── .github/                          # GitHub specific files
│   ├── workflows/                    # CI/CD pipelines
│   │   ├── ci.yml                   # Continuous Integration
│   │   ├── cd.yml                   # Continuous Deployment
│   │   └── security-scan.yml        # Security scanning
│   ├── ISSUE_TEMPLATE/              # Issue templates
│   └── PULL_REQUEST_TEMPLATE.md     # PR template
│
├── docs/                             # Dokumentacja projektu
│   ├── architecture/                # Dokumentacja architektury
│   │   ├── system-design.md        # Ogólny design systemu
│   │   ├── database-schema.md      # Schemat bazy danych
│   │   └── api-documentation.md    # Dokumentacja API
│   ├── deployment/                  # Instrukcje deployment
│   └── user-guide/                  # Przewodnik użytkownika
│
├── src/                             # Kod źródłowy
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── competitor/
│   │   │           └── cloudapp/
│   │   │               ├── CompetitorCloudApplication.java  # Main class
│   │   │               │
│   │   │               ├── config/              # Konfiguracja
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   ├── DatabaseConfig.java
│   │   │               │   ├── CacheConfig.java
│   │   │               │   └── SwaggerConfig.java
│   │   │               │
│   │   │               ├── controller/          # REST Controllers
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── CompetitorController.java
│   │   │               │   ├── ProductController.java
│   │   │               │   ├── PriceController.java
│   │   │               │   └── ReportController.java
│   │   │               │
│   │   │               ├── service/             # Business Logic
│   │   │               │   ├── AuthService.java
│   │   │               │   ├── CompetitorService.java
│   │   │               │   ├── ScraperService.java
│   │   │               │   ├── AnalysisService.java
│   │   │               │   └── NotificationService.java
│   │   │               │
│   │   │               ├── repository/          # Data Access Layer
│   │   │               │   ├── CompetitorRepository.java
│   │   │               │   ├── ProductRepository.java
│   │   │               │   ├── PriceHistoryRepository.java
│   │   │               │   └── UserRepository.java
│   │   │               │
│   │   │               ├── model/               # Domain Models
│   │   │               │   ├── entity/          # JPA Entities
│   │   │               │   │   ├── Competitor.java
│   │   │               │   │   ├── Product.java
│   │   │               │   │   ├── PriceHistory.java
│   │   │               │   │   └── User.java
│   │   │               │   ├── dto/             # Data Transfer Objects
│   │   │               │   │   ├── CompetitorDTO.java
│   │   │               │   │   ├── ProductDTO.java
│   │   │               │   │   └── PriceAnalysisDTO.java
│   │   │               │   └── enums/           # Enumerations
│   │   │               │       ├── CompetitorStatus.java
│   │   │               │       └── PriceChangeType.java
│   │   │               │
│   │   │               ├── security/            # Security related
│   │   │               │   ├── JwtTokenProvider.java
│   │   │               │   ├── JwtAuthenticationFilter.java
│   │   │               │   └── UserDetailsServiceImpl.java
│   │   │               │
│   │   │               ├── exception/           # Custom Exceptions
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   ├── CompetitorNotFoundException.java
│   │   │               │   └── UnauthorizedException.java
│   │   │               │
│   │   │               ├── util/                # Utility classes
│   │   │               │   ├── DateUtils.java
│   │   │               │   ├── ValidationUtils.java
│   │   │               │   └── EncryptionUtils.java
│   │   │               │
│   │   │               └── scraper/             # Web Scraping
│   │   │                   ├── ScraperEngine.java
│   │   │                   ├── ProxyManager.java
│   │   │                   └── RateLimiter.java
│   │   │
│   │   └── resources/
│   │       ├── application.yml              # Main configuration
│   │       ├── application-dev.yml          # Dev environment
│   │       ├── application-prod.yml         # Production environment
│   │       ├── application-test.yml         # Test environment
│   │       ├── db/
│   │       │   └── migration/               # Flyway/Liquibase migrations
│   │       │       ├── V1__initial_schema.sql
│   │       │       ├── V2__add_price_history.sql
│   │       │       └── V3__add_competitors.sql
│   │       ├── static/                      # Static resources
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       └── templates/                   # Email templates, etc.
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── competitor/
│                   └── cloudapp/
│                       ├── controller/      # Controller tests
│                       │   └── CompetitorControllerTest.java
│                       ├── service/         # Service tests
│                       │   └── CompetitorServiceTest.java
│                       ├── repository/      # Repository tests
│                       │   └── CompetitorRepositoryTest.java
│                       └── integration/     # Integration tests
│                           └── CompetitorApiIntegrationTest.java
│
├── docker/                              # Docker related files
│   ├── Dockerfile                       # Application Dockerfile
│   ├── Dockerfile.dev                   # Development Dockerfile
│   ├── docker-compose.yml               # Local development setup
│   └── docker-compose.prod.yml          # Production setup
│
├── k8s/                                 # Kubernetes manifests
│   ├── deployment.yaml                  # Application deployment
│   ├── service.yaml                     # Kubernetes service
│   ├── ingress.yaml                     # Ingress configuration
│   ├── configmap.yaml                   # Configuration
│   ├── secret.yaml                      # Secrets (template)
│   └── namespace.yaml                   # Namespace definition
│
├── terraform/                           # Infrastructure as Code
│   ├── main.tf                         # Main Terraform config
│   ├── variables.tf                    # Variables
│   ├── outputs.tf                      # Outputs
│   ├── modules/                        # Terraform modules
│   │   ├── vpc/                       # VPC module
│   │   ├── rds/                       # Database module
│   │   └── eks/                       # Kubernetes cluster
│   └── environments/
│       ├── dev/                        # Dev environment
│       ├── staging/                    # Staging environment
│       └── prod/                       # Production environment
│
├── scripts/                             # Helper scripts
│   ├── setup-dev.sh                    # Development setup
│   ├── run-tests.sh                    # Run all tests
│   ├── build.sh                        # Build script
│   └── deploy.sh                       # Deployment script
│
├── .gitignore                          # Git ignore file
├── .editorconfig                       # Editor configuration
├── pom.xml                             # Maven configuration
├── README.md                           # Main documentation
├── CONTRIBUTING.md                     # Contribution guidelines
├── ANALIZA_PROJEKTU.md                 # Project analysis
├── ARCHITECTURE.md                     # This file
├── LICENSE                             # License file
└── CHANGELOG.md                        # Change log

```

## 🏗️ Komponenty Systemu

### 1. API Gateway Layer
- **Cel**: Punkt wejścia dla wszystkich żądań
- **Technologia**: Spring Cloud Gateway
- **Funkcje**: Routing, rate limiting, authentication

### 2. Service Layer
```
┌─────────────────────────────────────────────────┐
│              API Gateway                        │
└──────────────┬──────────────────────────────────┘
               │
    ┌──────────┼──────────┬──────────┬──────────┐
    ▼          ▼          ▼          ▼          ▼
┌─────────┐ ┌──────┐ ┌─────────┐ ┌────────┐ ┌────────┐
│  Auth   │ │ Data │ │Analysis │ │ Notif. │ │Scraper │
│ Service │ │ Svc  │ │ Service │ │ Svc    │ │Service │
└─────────┘ └──────┘ └─────────┘ └────────┘ └────────┘
```

#### Auth Service
- Autentykacja użytkowników
- Zarządzanie tokenami JWT
- Role-based access control

#### Data Service
- CRUD operacje na danych
- Zarządzanie konkurentami
- Zarządzanie produktami

#### Analysis Service
- Analiza trendów cenowych
- Porównania konkurencyjne
- Generowanie insightów

#### Notification Service
- Email notifications
- Webhook callbacks
- Alert management

#### Scraper Service
- Web scraping
- Data extraction
- Proxy management

### 3. Data Layer

```
┌─────────────────────────────────────────┐
│         Application Layer               │
└──────────────┬──────────────────────────┘
               │
    ┌──────────┼──────────┐
    ▼          ▼          ▼
┌──────────┐ ┌───────┐ ┌────────┐
│PostgreSQL│ │ Redis │ │ S3/    │
│   (RDS)  │ │(Cache)│ │MinIO   │
└──────────┘ └───────┘ └────────┘
```

#### PostgreSQL
- Primary data store
- ACID compliance
- Relational data

#### Redis
- Cache layer
- Session storage
- Real-time data

#### S3/MinIO
- File storage
- Backups
- Reports storage

## 📊 Schemat Bazy Danych (Konceptualny)

```sql
-- Users table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Competitors table
CREATE TABLE competitors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    website_url VARCHAR(500),
    status VARCHAR(50) NOT NULL,
    created_by BIGINT REFERENCES users(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Products table
CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    competitor_id BIGINT REFERENCES competitors(id),
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(100),
    url VARCHAR(500),
    current_price DECIMAL(10, 2),
    currency VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Price history table
CREATE TABLE price_history (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT REFERENCES products(id),
    price DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_product_date (product_id, recorded_at)
);

-- Alerts table
CREATE TABLE alerts (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    product_id BIGINT REFERENCES products(id),
    alert_type VARCHAR(50) NOT NULL,
    threshold DECIMAL(10, 2),
    is_active BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 🔄 Przepływ Danych

### 1. User Request Flow
```
User → API Gateway → Auth Filter → Controller → Service → Repository → Database
                                                    ↓
                                                 Cache (Redis)
```

### 2. Scraping Flow
```
Scheduler → Scraper Service → Target Website
                ↓
         Extract Data
                ↓
         Validate & Transform
                ↓
         Save to Database
                ↓
         Trigger Analysis
                ↓
         Send Notifications (if needed)
```

### 3. Analysis Flow
```
New Price Data → Analysis Service → Compare with History
                        ↓
                 Calculate Metrics
                        ↓
                 Generate Insights
                        ↓
                 Store Results
                        ↓
                 Notify Users (if threshold met)
```

## 🔐 Security Architecture

### Authentication Flow
```
1. User Login → Auth Service
2. Validate Credentials
3. Generate JWT Token
4. Return Token to Client
5. Client sends Token in Header
6. API Gateway validates Token
7. Forward request to Service
```

### Security Layers:
- **Transport**: HTTPS/TLS 1.3
- **Authentication**: JWT tokens
- **Authorization**: Role-based (RBAC)
- **Data**: Encryption at rest and in transit
- **API**: Rate limiting, input validation
- **Infrastructure**: VPC, Security Groups, WAF

## 📡 API Endpoints (Planowane)

### Authentication
```
POST   /api/v1/auth/register       - Register new user
POST   /api/v1/auth/login          - User login
POST   /api/v1/auth/refresh        - Refresh token
POST   /api/v1/auth/logout         - Logout
```

### Competitors
```
GET    /api/v1/competitors         - List all competitors
GET    /api/v1/competitors/{id}    - Get competitor details
POST   /api/v1/competitors         - Add new competitor
PUT    /api/v1/competitors/{id}    - Update competitor
DELETE /api/v1/competitors/{id}    - Delete competitor
```

### Products
```
GET    /api/v1/products            - List all products
GET    /api/v1/products/{id}       - Get product details
POST   /api/v1/products            - Add new product
PUT    /api/v1/products/{id}       - Update product
DELETE /api/v1/products/{id}       - Delete product
GET    /api/v1/products/{id}/price-history  - Price history
```

### Analysis
```
GET    /api/v1/analysis/trends     - Price trends
GET    /api/v1/analysis/comparison - Competitor comparison
GET    /api/v1/analysis/reports    - Generate reports
```

### Alerts
```
GET    /api/v1/alerts              - List user alerts
POST   /api/v1/alerts              - Create alert
PUT    /api/v1/alerts/{id}         - Update alert
DELETE /api/v1/alerts/{id}         - Delete alert
```

## 🚀 Deployment Architecture

### Kubernetes Deployment
```yaml
# High-level Kubernetes structure
Namespace: competitor-app
  ├── Deployments
  │   ├── api-gateway (replicas: 3)
  │   ├── auth-service (replicas: 2)
  │   ├── data-service (replicas: 3)
  │   ├── scraper-service (replicas: 2)
  │   └── analysis-service (replicas: 2)
  │
  ├── Services
  │   ├── api-gateway-svc (LoadBalancer)
  │   └── internal-services (ClusterIP)
  │
  ├── ConfigMaps
  │   └── app-config
  │
  ├── Secrets
  │   ├── db-credentials
  │   └── api-keys
  │
  └── Ingress
      └── app-ingress (HTTPS)
```

## 🔍 Monitoring & Observability

### Metrics
- **Prometheus** - Metric collection
- **Grafana** - Visualization
- **Custom metrics**: API latency, error rates, scraping success rate

### Logging
- **ELK Stack** (Elasticsearch, Logstash, Kibana)
- Centralized logging
- Log aggregation from all services

### Tracing
- **Jaeger/Zipkin** - Distributed tracing
- Request flow tracking
- Performance bottleneck identification

### Alerting
- **AlertManager** - Alert routing
- Integration with Slack/Email
- PagerDuty for critical issues

## 📈 Skalowanie

### Horizontal Scaling
- Kubernetes HPA (Horizontal Pod Autoscaler)
- Scale based on CPU/Memory/Custom metrics
- Min replicas: 2, Max replicas: 10

### Database Scaling
- Read replicas for PostgreSQL
- Connection pooling
- Query optimization
- Partitioning for large tables

### Cache Strategy
- Redis cluster for high availability
- Cache-aside pattern
- TTL-based expiration

## 🔄 CI/CD Pipeline

```
Code Push → GitHub
    ↓
GitHub Actions Triggered
    ↓
├─ Lint Code (Checkstyle)
├─ Run Unit Tests
├─ Run Integration Tests
├─ Security Scan (Snyk/SonarQube)
├─ Build Docker Image
├─ Push to Registry
    ↓
Deploy to Dev Environment
    ↓
Smoke Tests
    ↓
Deploy to Staging (manual approval)
    ↓
E2E Tests
    ↓
Deploy to Production (manual approval)
    ↓
Health Checks
    ↓
Success! 🎉
```

## 📝 Uwagi końcowe

Ta architektura jest propozycją dla projektu w początkowej fazie. Może być dostosowana w zależności od:
- Rzeczywistych wymagań biznesowych
- Budżetu i zasobów
- Skali planowanego wdrożenia
- Preferencji technologicznych zespołu

**Next Steps:**
1. Zatwierdzenie architektury przez stakeholderów
2. Setup podstawowej struktury projektu
3. Implementacja MVP zgodnie z zaplanowaną architekturą
4. Iteracyjny rozwój i doskonalenie

---

**Wersja:** 1.0  
**Data:** 2025-12-03  
**Status:** Proposal
