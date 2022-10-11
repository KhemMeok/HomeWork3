package people.sevice;

import java.util.List;
import java.util.Map;

import people.model.Gender;
import people.model.People;
import people.model.Pet;

public interface PeopleService   {
    Map<Gender,Long> cnopbg(List<People> list); 
    List<People> numofpetmorethanone(List<People> list,int num);
    List<People> findByPetType(List<People> list,Pet petType);
    Gender mostHaveCat(List<People> list,Pet petType);
    boolean peopleNoPet(List<People> list);
    List<Pet> findAppPets(List<People> list);
    Map<Integer,List<People>> groupByAge(List<People> list);
	Map<Boolean, List<People>> groupByAgeUpperThan18(List<People> list,Integer age);
    Map<Object, List<Object>> groupByPet(List<People> list);
    List<People> filterPeople(List<People> list);
	People yoengPeople(List<People> list);

}