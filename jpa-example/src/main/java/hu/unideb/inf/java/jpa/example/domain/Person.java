package hu.unideb.inf.java.jpa.example.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personID;
    private String fullName;
    @OneToMany(mappedBy = "person", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Car> cars;
    private Date lastUpdate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @PreUpdate
    @PrePersist
    public void updateLastUpdate() {
        setLastUpdate(new Date());
    }

    @Override
    public String toString() {
        return "Person [personID=" + personID + ", fullName=" + fullName + ", cars=" + cars + ", lastUpdate=" + lastUpdate + "]";
    }
    
}
