package people.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import people.model.Gender;
import people.model.People;
import people.model.Pet;

public class DataDBimpl implements DataDB {

	public List<Pet> pet(int id) {
		String sql2 = "SELECT p.\"name\" from pet p inner join peopledetail pd on pd.petid = p.petid where pd.peoid='"
				+ id + "';";
		List<Pet> listPet = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = ConnectToDB.connect().prepareStatement(sql2);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// System.out.println(resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getString(4));
				// listPet.add();

				String pets = resultSet.getString(1);
				if (pets.contains(String.valueOf(Pet.CAT))) {
					listPet.add(Pet.CAT);
				}
				if (pets.contains(String.valueOf(Pet.DOG))) {
					listPet.add(Pet.DOG);
				}
				if (pets.contains(String.valueOf(Pet.COW))) {
					listPet.add(Pet.COW);
				}

				if (pets.contains(String.valueOf(Pet.FISH))) {
					listPet.add(Pet.FISH);
				}
				if (pets.contains(String.valueOf(Pet.BRID))) {
					listPet.add(Pet.BRID);
				}

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return listPet;
	}

	@Override
	public List<People> selectAllPeople() {
		int id = 0;
		String sql = "SELECT * FROM people";

		List<People> listPeople = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = ConnectToDB.connect().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// System.out.println(resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getString(4));
				id = Integer.parseInt(String.valueOf(resultSet.getInt(1)));
				listPeople.add(new People(resultSet.getString(2),
						resultSet.getString(3).contains("F") ? Gender.Female : Gender.Male,
						Integer.parseInt(resultSet.getString(4)), pet(id)));
			}
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		return listPeople;
	}

	@Override
	public List<People> selectPeople() {
		return null;

	}

}
