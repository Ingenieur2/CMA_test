package ru.helperfiles;

import java.util.Date;

public class HelperPersonNew {
    private long id;
    private String name;
    private Date birthDate;

    public HelperPersonNew() {
    }

    public HelperPersonNew(long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
