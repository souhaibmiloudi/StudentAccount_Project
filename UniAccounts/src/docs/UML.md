```mermaid 
classDiagram
    class StudentAccount {
        -String id
        -String fullName
        -String email
        -String phone
        -String level
        -String major
        -boolean scholarship
        -List~String~ courses
        +StudentAccount(...)
        +getId()
        +getFullName()
        +getEmail()
        +getPhone()
        +getLevel()
        +getMajor()
        +isScholarship()
        +getCourses()
        +clone()
        +CloneWithIdentify(...)
    }

    class StudentAccountBuilder {
        -String id
        -String fullName
        -String email
        -String phone
        -String level
        -String major
        -boolean scholarship
        -List~String~ courses
        +phone()
        +level()
        +major()
        +scholarship()
        +courses()
        +build()
    }

    class UniversitySystem {
        -UniversitySystem instance
        -AccountRepository repository
        -AuditLog auditLog
        -UniversitySystem()
        +getInstance()
        +addAccount()
        +getAccount()
        +getAuditLog()
    }

    class AccountRepository {
        -Map~String,StudentAccount~ accounts
        +addAccount()
        +getAccount()
    }

    class AuditLog {
        -List~String~ auditlog
        +log()
        +getAuditLog()
    }

    StudentAccountBuilder ..> StudentAccount : builds
    UniversitySystem --> AccountRepository : uses
    UniversitySystem --> AuditLog : uses
    AccountRepository --> StudentAccount : stores ```