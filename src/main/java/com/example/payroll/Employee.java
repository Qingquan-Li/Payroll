package com.example.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Define an Employee in our system.
 */
// `@Entity` is a JPA annotation to make this object ready for
// storage in a JPA-based data store.
@Entity
class Employee {

    /**
     * id, name, and role are attributes of our Employee domain object.
     * id is marked with more JPA annotations to indicate it’s the primary key
     * and automatically populated by the JPA provider.
     */
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;

    // Default constructor.
    Employee() {
    }

    /**
     * a custom constructor is created when we need to create a new instance,
     * but don’t yet have an id.
     */
    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) &&
                Objects.equals(this.name, employee.name) &&
                Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", role='" + this.role + '\'' + "}";
    }
}
