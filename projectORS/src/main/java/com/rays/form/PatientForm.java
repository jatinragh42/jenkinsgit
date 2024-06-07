package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PatientDTO;
// import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidEmail;
import com.rays.validation.ValidLong;

public class PatientForm extends BaseForm {

    @NotEmpty(message = "Please enter name")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Invalid name format")
    private String name;

    @NotEmpty(message = "Please enter email")
    @ValidEmail(message = "Invalid emailId")
    private String email;

    @NotNull(message = "Please enter mobile")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid input for mobile")
    private String mobile;

    @NotNull(message = "Please enter date")
    @ValidDate(message = "Invalid date format or value")
    private String dateOfVisit;

    private String diseaseName;

    @NotNull(message = "Please enter diseaseId")
    @ValidLong(message = "Invalid input for id")
    @Min(value = 1, message = "DiseaseId should be greater than 0")
    private String diseaseId;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    @Override
    public BaseDTO getDto() {
        PatientDTO dto = initDTO(new PatientDTO());

        dto.setName(name);
        if (dateOfVisit != null && !dateOfVisit.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(dateOfVisit);
                dto.setDateOfVisit(parsedDate);
            } catch (ParseException e) {
                // Handle parse exception if needed
                e.printStackTrace();
            }
        }

        if (mobile != null && !mobile.isEmpty()) {
            dto.setMobile(Long.valueOf(mobile));
        }

        if (diseaseId != null && !diseaseId.isEmpty()) {
            dto.setDiseaseId(Long.valueOf(diseaseId));
        }

        dto.setEmail(email);
        dto.setDiseaseName(diseaseName);

        return dto;
    }
}
