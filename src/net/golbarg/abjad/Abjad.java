package net.golbarg.abjad;

public class Abjad {
	private char character;
	private int value;

	public Abjad(char character, int value) {
		this.character = character;
		this.value = value;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Abjad [character=" + character + ", value=" + value + "]";
	}

}
