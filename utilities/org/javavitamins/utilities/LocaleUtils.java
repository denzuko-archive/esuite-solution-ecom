package org.javavitamins.utilities;

import java.text.DateFormat;
import java.util.Locale;

public class LocaleUtils {

	public static void main(String[] args) {

		listAvailableLocales();

	}

	public static void listAvailableLocales() {

		DateFormat df = DateFormat.getDateInstance();
		Locale[] locales = df.getAvailableLocales();

		for (int i = 0; i < locales.length; i++) {

			Locale locale = locales[i];

			System.out.println(locale.getDisplayName() + "; "
					+ locale.getLanguage() + ", " + locale.getCountry());

		}

	}

}
