package org.questionBank.data;
// Generated Nov 28, 2016 9:15:21 PM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", catalog = "questionbank")
public class Department implements java.io.Serializable {

	private Integer id;
	private String name;
	private String abbreviation;
	private Set<Course> courses = new HashSet<Course>(0);

	public Department() {
	}

	public Department(String name, String abbreviation, Set<Course> courses) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "abbreviation", length = 10)
	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
