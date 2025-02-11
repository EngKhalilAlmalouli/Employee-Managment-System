package EmployeesManagement.EmployeesManagement.configuration;

public class NotFoundInDatabaseException extends Exception {


    public NotFoundInDatabaseException(String message) {
        super(message);
    }
}
