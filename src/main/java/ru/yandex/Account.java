package ru.yandex;

public class Account {

	private final String name;

	public Account(String name) {
		this.name = name;
	}

	public boolean checkNameToEmboss() {
		return name != null && name.matches("(?=^.{3,19}$)\\S+ \\S+");
	}

}
