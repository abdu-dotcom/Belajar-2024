package net.javaguides.department_service.exception;


public class ResourceNotFoundException extends RuntimeException {

    private String ResourseName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String resourseName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : '%s'",resourseName, fieldName, fieldValue));
        ResourseName = resourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
