import java.util.HashMap;
import java.util.Map;

public class DataStore {
	private Map<String, Person> personMap = new HashMap<>();
	
	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}
	
	private DataStore(){
		
		personMap.put("apple", new Person("apple", "яблоко", 1815));
		personMap.put("helicopter", new Person("helicopter", "вертолёт", 1986));
		personMap.put("go", new Person("go", "идти", 2007));
	}

	public Person getPerson(String originalWord) {
		return personMap.get(originalWord);
	}

	public void putPerson(Person person) {
		personMap.put(person.getOriginalWord(), person);
	}
}
