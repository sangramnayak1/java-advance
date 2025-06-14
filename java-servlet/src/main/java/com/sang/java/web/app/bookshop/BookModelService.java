package com.sang.java.web.app.bookshop;

import java.util.ArrayList;
import java.util.List;

public class BookModelService {

	public List getAvailableBooks(BookType type) {

		List brands = new ArrayList();

		if (type.equals(BookType.JAVA)) {
			brands.add("Adrianna Vineyard");
			brands.add(("J. P. Chenet"));

		} else if (type.equals(BookType.PYTHON)) {
			brands.add("Glenfiddich");
			brands.add("Johnnie Walker");

		} else if (type.equals(BookType.GO)) {
			brands.add("Sangram Nayak");

		} else {
			brands.add("No Brand Available");
		}
		return brands;
	}
}
