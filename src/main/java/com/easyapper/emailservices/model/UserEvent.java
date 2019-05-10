package com.easyapper.emailservices.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import java.util.Map;
import java.util.Objects;

@Document(collection = "users_events")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEvent {

    @Id
    public String id;
    @Field("user-adv-loc")
    @NotEmpty(message = "userAdvAndLoc can not be empty.")
    private Map<String,String> userAdvAndLoc;
    @Field("email")
    @NotEmpty(message = "email can not be empty.")
    private String email;
    @Field("hashcode")
    private Integer hashCode;
    @Field("is-active")
    private Boolean isActive = true;


    public UserEvent(){

    }

    public UserEvent(String id, @NotEmpty(message = "userAdvAndLoc can not be empty.") Map<String, String> userAdvAndLoc, @NotEmpty(message = "email can not be empty.") String email) {
        this.id = id;
        this.userAdvAndLoc = userAdvAndLoc;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getUserAdvAndLoc() {
        return userAdvAndLoc;
    }

    public void setUserAdvAndLoc(Map<String, String> userAdvAndLoc) {
        this.userAdvAndLoc = userAdvAndLoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(Integer hashCode) {
        this.hashCode = hashCode;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEvent)) return false;
        UserEvent userEvent = (UserEvent) o;
        return Objects.equals(getId(), userEvent.getId()) &&
                Objects.equals(getUserAdvAndLoc(), userEvent.getUserAdvAndLoc()) &&
                Objects.equals(getEmail(), userEvent.getEmail()) &&
                Objects.equals(getHashCode(), userEvent.getHashCode()) &&
                Objects.equals(isActive, userEvent.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserAdvAndLoc());
    }
}
