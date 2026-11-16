package logging;

import java.util.ArrayList;
import java.util.List;

public class AuditLog {

    private List<String> auditlog = new ArrayList<>();

    public void log(String message) {
        auditlog.add(message);
    }

    public List<String> getAuditLog() {
        return new ArrayList<>(auditlog);
    }
}
