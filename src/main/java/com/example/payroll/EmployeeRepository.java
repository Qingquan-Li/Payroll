/*
 * Spring Data JPA provides repository support for the Java Persistence API.
 * Spring Data JPA repositories are interfaces with methods supporting
 * creating, reading, updating, and deleting records
 * against a back end data store.
 *
 * Spring Data’s repository solution makes it possible to
 * sidestep data store specifics and instead solve a majority of problems
 * using domain-specific terminology.
 */

package com.example.payroll;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring makes accessing data easy.
 * By simply declaring the following EmployeeRepository interface
 * we automatically will be able to
 * - Create new Employees
 * - Update existing ones
 * - Delete Employees
 * - Find Employees (one, all, or search by simple or complex properties)
 * To get all this free functionality, all we had to do was
 * declare an interface which extends Spring Data JPA’s JpaRepository,
 * specifying the domain type as Employee and the id type as Long.
 */
interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
