package com.example.srilanka_cricket_service.constants;

import org.springframework.stereotype.Component;


public class ApplicationConstants {
    public static final String FAQ_ID_NOT_FOUND = "Faq question not found for the provided id";
    public static final String COLON = " : ";

    public static final String BAD_REQUEST = "Bad request";
    public static final String FAQ_ADDED_SUCCESSFULLY = "FAQ added successfully";
    public static final String FAQ_QUESTION_ALREADY_EXIST = "Faq question already exist";
    public static final String FAQ_NOT_EXIST = "No FAQ’s to preview";
    public static final String SFTP = "SFTP";
    public static final String AUTHORIZED_ACCESS = "User type not authorized to access this resource.";
    public static final String MAXIMUM_FILE_SIZE = "Maximum upload size exceeded. Please upload files smaller than 5MB.";
    public static final String INTERNAL_SERVER = "Internal Server Error";
    public static final String STATUS = "status";
    public static final String HTML = ".*/html/";
    public static final String UNAUTHORIZED_ACCESS = "Unauthorized access";
    public static final String TIMESTAMP = "timestamp";
    public static final String STATUS_VALUE = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";
    public static final String PATH = "path";
    public static final String UNAUTHORIZED = "Unauthorized";

    //common CRUD response messages
    public static final String UPDATED = "Updated Successfully!";
    public static final String PAGE_CAN_NOT_BE_NEGATIVE = "Page can't be negative";
    public static final String SIZE_CAN_NOT_BE_NEGATIVE = "Size can't be negative";
    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final String PAGE_NUMBER = "pageNumber";
    public static final String PAGE_SIZE = "pageSize";

    //FILE
    public static final String DEFAULT_IMAGE_ICON_PATH = "default/icon/path.png";
    public static final String JPEG = "image/jpeg";
    public static final String JPG = "image/jpg";
    public static final String PNG = "image/png";
    public static final String INVALID_FILE_TYPE = "Only JPEG, JPG, and PNG files are allowed.";
    public static final String FILE_SIZE_EXCEEDED = "File size must not exceed 5MB.";

    //PRODUCT
    public static final String PRODUCT_ID_CAN_NOT_BE_NULL = "Product ID Can't be null";
    public static final String PRODUCT_ID_CAN_NOT_BE_BLANK = "Product ID Can't be blank";
    public static final String FILE_CAN_NOT_BE_NULL = "File Can't be null";
    public static final String PRODUCT_ID_NOT_FOUND = "Product is not found ";
    public static final String CANNOT_BE_BLANK = "cannot be blank";

    //common CRUD response messages
    public static final String DELETED = "Successfully deleted";
    public static final String ID_CAN_NOT_BE_NULL = "Id cannot be null.";
    public static final String ID_CAN_NOT_BE_BLANK = "Id cannot be blank.";


    //FAQ
    public static final String QUESTION_SIZE_VALIDATION = "Question must be between 1 and 50 characters.";
    public static final String QUESTION_CAN_NOT_BE_NULL = "Question cannot be null.";
    public static final String QUESTION_CAN_NOT_BE_BLANK = "Question cannot be blank.";
    public static final String ANSWER_SIZE_VALIDATION = "Answer must be between 1 and 100 characters.";
    public static final String ANSWER_CAN_NOT_BE_NULL = "Answer cannot be null.";
    public static final String ANSWER_CAN_NOT_BE_BLANK = "Answer cannot be blank.";
    public static final String SERVICE_NAME_ALREADY_EXIST = "serviceName Already Exist";
    public static final String SERVICE_UPDATED = "Updated Successfully!";
    public static final String FEATURE_ID_DOES_NOT_BELONG = "Feature Does not belongs to service";
    public static final String FEATURE_LIMIT_EXCEEDED = "Maximum 10 records can be added";
    public static final String SERVICE_ID_NOT_FOUND = "Service ID not found";
    public static final String FEATURE_NAME_ALREADY_EXISTS = "Feature Name Already exist";
    public static final String FEATURE_ID_NOT_FOUND = "Feature Id not found";
    public static final String FEATURE_SAVED_SUCCESSFULLY = "feature saved successfully";
    public static final String FEATURE_ALREADY_DELETED = "features already deleted";
    public static final String FEATURE_DELETED_SUCCESSFULLY = "feature deleted successfully";
    public static final String FEATURE_ALREADY_DELETED_CANNOT_UPDATE = "feature already deleted can not be updated";
    public static final String PRODUCT_IS_ALREADY_IN_GIVE_STATUS = "Product is already in give status";
    public static final String PRODUCT_STATUS_ACTIVATED = "Successfully status updated";
    public static final String PAGE_NO_REQUIRED = "Page number is required";
    public static final String PAGE_SIZE_REQUIRED = "Page size is required";
    public static final String STRING_CHANGE = "Question %02d";
    public static final String CREATED_DATE = "createdDate";
    public static final String PAGE_NUMBER_GR_ZERO = "Page Number must be greater than zero";
    public static final String PAGE_SIZE_GR_ZERO = "Page size must be greater than zero";

    public static final String NOT_GRANTED = "You are not granted to access this API.";
    public static final String SERVICE_IDS_NOT_FOUND = "ServiceIds not found: ";
    public static final String CREATE_OR_UPDATE_PRODUCT = "createOrUpdateProduct";
}
