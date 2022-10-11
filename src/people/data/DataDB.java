package people.data;

import java.util.List;

import people.model.People;
 

public interface DataDB {
	List<People> selectAllPeople();

	List<People> selectPeople();
}
