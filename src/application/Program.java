package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.ImportedProduct;
import entitites.Product;
import entitites.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("common, used or imported (c/u/i)? ");
			char t = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (t == 'c') {
				list.add(new Product(name, price));
			} 
			else if (t == 'i') {
				System.out.print("Customs fee: ");
				double cf = sc.nextDouble();
				list.add(new ImportedProduct(name, price, cf));
			} 
			else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date mDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, mDate));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");

		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}

		sc.close();
	}

}