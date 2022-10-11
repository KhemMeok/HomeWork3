package people.model;

import java.util.List;

public class People {
	private String name;
	private Gender gender;
	private int age;
	private List<Pet> pet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Pet> getPet() {
		return pet;
	}

	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}

	public People(String name, Gender gender, int age, List<Pet> list) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pet = list;
	}

}