package com.loggingAuditing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Audit record class to hold individual audit entries
class AuditRecord {
    private String action;
    private LocalDateTime timestamp;

    public AuditRecord(String action) {
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "AuditRecord{" +
                "action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

// Audit Service class
public class AuditService {
    private List<AuditRecord> auditRecords;

    public AuditService() {
        this.auditRecords = new ArrayList<>();
    }

    // Method to log an action
    public void logAction(String action) {
        AuditRecord record = new AuditRecord(action);
        auditRecords.add(record);
        System.out.println("Logged action: " + record);
    }

    // Method to retrieve all audit records
    public List<AuditRecord> getAuditRecords() {
        return new ArrayList<>(auditRecords);
    }

    // Method to clear audit records (if needed)
    public void clearAuditRecords() {
        auditRecords.clear();
        System.out.println("Audit records cleared.");
    }
}
