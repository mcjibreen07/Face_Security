package com.Alanjro_jr.capture;

public class ModelPerson {

    private int id;
    private String first_name, last_name, dob, office, facebook, image, date;

    public ModelPerson() {
    }

    public ModelPerson(String first_name, String office, String image) { //LastPerson
        this.first_name = first_name;
        this.office = office;
        this.image = image;
    }

    public ModelPerson(int id, String first_name, String last_name, String dob, String office, String facebook, String date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.office = office;
        this.facebook = facebook;
      
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
