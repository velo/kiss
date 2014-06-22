package com.marvinformatics.kiss.querydslmockery.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private String id;

	@Column
	private String name;

	@Column
	private Long age;

	@ManyToMany
	private List<Person> child;

	@OneToOne
	private Address address;

	public Person() {
		super();
	}

	public Person(String id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public Person(String id, String name, Person... child) {
		super();
		this.id = id;
		this.name = name;
		this.child = Arrays.asList(child);
	}

	public Person(String id, String name, Long age, List<Person> child) {
		this();
		this.id = id;
		this.name = name;
		this.age = age;
		this.child = child;
	}

	public Person(String id, String name, Address address, Person... child) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.child = Arrays.asList(child);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Person setId(String id) {
		this.id = id;
		return this;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	public Long getAge() {
		return age;
	}

	public Person setAge(Long age) {
		this.age = age;
		return this;
	}

	public List<Person> getChild() {
		if (child == null)
			child = new ArrayList<Person>();
		return child;
	}

	public Person setChild(List<Person> child) {
		this.child = child;
		return this;
	}

	public Person addChild(Person p1) {
		getChild().add(p1);
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (child == null) {
			if (other.child != null)
				return false;
		} else if (!child.equals(other.child))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", child=" + child + ", address=" + address + "]";
	}
}
