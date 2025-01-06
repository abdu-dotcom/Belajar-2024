package net.javaguides.employeeservice.exception;


public class ResourceNotFoundException extends RuntimeException {

    private String ResourseName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourseName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s'",resourseName, fieldName, fieldValue));
        ResourseName = resourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
