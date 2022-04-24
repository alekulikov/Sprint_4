package ru.yandex;

import static org.junit.Assert.assertEquals;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
@DisplayName("Проверка разных вариантов имени")
public class AccountTest {

	private final String name;
	private final boolean expected;


	public AccountTest(String name, boolean expected) {
		this.name = name;
		this.expected = expected;
	}

	@Parameters(name = "name = \"{0}\" expectedResult = \"{1}\"")
	public static Object[][] data() {
		return new Object[][]{
				{null, false},
				{"", false},
				{"Иванов ИванИванИванИ", false},
				{" ИванИванИванИ", false},
				{"ИванИванИванИ ", false},
				{"ИванИванИван", false},
				{"Иванов  Иван", false},
				{"Иванов	Иван", false},
				{"Ив", false},
				{"Иванов Иван", true},
				{"И И", true},
		};
	}

	@Test
	public void checkNameValidation() {
		Account account = new Account(name);
		boolean actualResult = account.checkNameToEmboss();

		assertEquals("validation failed", expected, actualResult);
	}

}
