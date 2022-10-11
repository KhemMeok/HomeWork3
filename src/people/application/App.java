package people.application;
import java.util.List;
import java.util.Map;

import people.data.DataDB;
import people.data.DataDBimpl;
import people.model.Gender;
import people.model.People;
import people.model.Pet;
import people.sevice.PeopleService;
import people.sevice.PeopleServiceIMP;
 

public class App {
	private final PeopleService peopleService = new PeopleServiceIMP();
	private final DataDB dataDB = new DataDBimpl();
//    private final List<People> l_o_p = List.of(
//            new People("khem", Gender.Male, 17, List.of(Pet.COW)),
//            new People("khem", Gender.Female, 20, List.of(Pet.CAT, Pet.COW)),
//            new People("khem", Gender.Male, 23, List.of(Pet.CAT)),
//            new People("khem", Gender.Female, 19, List.of(Pet.CAT)),
//            new People("khem", Gender.Male, 32, List.of(Pet.DOG)),
//            new People("khem", Gender.Male, 22, List.of(Pet.CAT)),
//            new People("khem", Gender.Female, 21, List.of(Pet.CAT)),
//            new People("khem", Gender.Male, 21, List.of(Pet.FISH)),
//            new People("khem", Gender.Male, 28, List.of(Pet.CAT)),
//            new People("khem1", Gender.Female, 17, List.of(Pet.BRID)));
	List<People> l_o_p = dataDB.selectAllPeople();

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.showByGender();
		app.showPeopleHavePetMoreThanOne();
		app.showWhoHaveCat();
		app.showPeopleLikeCatMost();
		app.showPeoleNoPet();
		app.showPeopleYoung();
		app.showAllPet();
		app.showGroupByAge();
		app.showGroupByAgeUpperThan18();
		app.showGroupByPet();
		app.showfilter();

//        app.showPeople();

	}

	public void showPeople() {
		List<People> selectAllPeople = dataDB.selectAllPeople();
		selectAllPeople.stream().forEach(
				p -> System.out.println(p.getName() + "," + p.getGender() + "," + p.getAge() + "," + p.getPet()));
	}

//
	public void showByGender() {
		System.out.println("----------------------- show by gender--------------------------");
		Map<Gender, Long> cnopbg = peopleService.cnopbg(l_o_p);
		System.out.println(cnopbg);
	}

	public void showPeopleHavePetMoreThanOne() {
		System.out.println("---------------------------People have Pet more than One-----------------");
		List<People> numofpetmorethanone = peopleService.numofpetmorethanone(l_o_p, 1);
		numofpetmorethanone.forEach(peoples -> System.out.println(peoples.getName()));
	}

	public void showWhoHaveCat() {
		System.out.println("----------------------------Peopele who have cat------------------------");
		List<People> findByPetType = peopleService.findByPetType(l_o_p, Pet.CAT);
		findByPetType.forEach(p -> System.out.println(p.getName() + " :" + p.getPet()));
	}

	public void showPeopleLikeCatMost() {
		System.out.println("-----------------------------People Like Cat Most-----------------------------");
		Gender mostHaveCat = peopleService.mostHaveCat(l_o_p, Pet.CAT);
		System.out.println(mostHaveCat);
	}

	public void showPeoleNoPet() {
		System.out.println("--------------------people no pet---------------------------");
		boolean peopleNoPet = peopleService.peopleNoPet(l_o_p);
		System.out.println(peopleNoPet);
	}

	public void showPeopleYoung() {
		System.out.println("-----------------------------People Young Age-----------------------------");
		People yoengPeople = peopleService.yoengPeople(l_o_p);
		System.out.println(yoengPeople.getName());
	}

	public void showAllPet() {
		System.out.println("-----------------------All Pet------------------------");
		List<Pet> findAppPets = peopleService.findAppPets(l_o_p);
		System.out.println(findAppPets);
	}

	public void showGroupByAge() {
		System.out.println("----------------------------Group By Age--------------------------");
		Map<Integer, List<People>> groupByAge = peopleService.groupByAge(l_o_p);
		groupByAge.forEach((k, v) -> {
			System.out.println(k);
			// System.out.println(v.stream().map(p->p.getName()).collect(Collectors.toList()));
			v.forEach((p) -> {
				System.out.println(p.getName() + ":" + p.getAge());
			});
		});

	}

	public void showGroupByAgeUpperThan18() {
		System.out.println("----------------------upper than 18---------------------");
		Map<Boolean, List<People>> groupByAgeUpperThan18 = peopleService.groupByAgeUpperThan18(l_o_p, 18);
		groupByAgeUpperThan18.forEach((k, v) -> {
			System.out.println(k);
			// System.out.println(v.stream().map(p->p.getName()).collect(Collectors.toList()));
			v.forEach((p) -> {
				System.out.println(p.getName() + ":" + p.getAge());
			});
		});
	}

	public void showGroupByPet() {
		System.out.println("----------------------Group By Pet---------------------");
		Map<Object, List<Object>> groupByPet = peopleService.groupByPet(l_o_p);
		groupByPet.forEach((k, v) -> {
			System.out.println(k);
			// System.out.println(v.stream().map(p->p.getName()).collect(Collectors.toList()));
			v.forEach((p) -> {
				System.out.println(p);
			});
		});
	}

	public void showfilter() {
		System.out.println("-------------------------filter-------------------------------");
		List<People> filterPeople = peopleService.filterPeople(l_o_p);
		filterPeople.forEach((p) -> {
			System.out.println(p.getName());
		});
	}
}