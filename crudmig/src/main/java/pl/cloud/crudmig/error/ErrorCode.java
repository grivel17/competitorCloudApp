package pl.cloud.crudmig.error;

public enum ErrorCode {
    // Competitor related errors
    COMPETITOR_NOT_FOUND("COMP-001", "Competitor not found"),
    COMPETITOR_ALREADY_EXISTS("COMP-002", "Competitor already exists"),
    INVALID_COMPETITOR_DATA("COMP-003", "Invalid competitor data"),
    
    // Validation errors
    VALIDATION_ERROR("VAL-001", "Validation error"),
    MISSING_REQUIRED_FIELDS("VAL-002", "Missing required fields"),
    
    // System errors
    INTERNAL_ERROR("SYS-001", "Internal server error"),
    DATABASE_ERROR("SYS-002", "Database error");
    
    private final String code;
    private final String description;
    
    ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getDescription() {
        return description;
    }
}
