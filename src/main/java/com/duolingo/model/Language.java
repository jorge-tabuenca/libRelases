package com.duolingo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY, mappedBy = "language")
    private Set<User> users;
    
    @ManyToMany(mappedBy = "languages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Language() {
    }

	public Language(short id, String name, Set<User> users, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.courses = courses;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", users=" + users + ", courses=" + courses + "]";
	}
}
