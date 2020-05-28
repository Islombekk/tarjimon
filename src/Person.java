
public class Person {
	private String originalWord;
	private String translatedWord;
	private int birthYear;
	
	public Person(String originalWord, String translatedWord, int birthYear) {
		this.originalWord = originalWord;
		this.translatedWord = translatedWord;
		this.birthYear = birthYear;
	}

	public String getOriginalWord() {
		return originalWord;
	}

	public String getTranslatedWord() {
		return translatedWord;
	}

	public int getBirthYear() {
		return birthYear;
	}
}
