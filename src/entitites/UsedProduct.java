package entitites;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UsedProduct extends Product {

	private Date manufactured;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactured) {
		super(name, price);
		this.manufactured = manufactured;
	}

	public Date getManufactured() {
		return manufactured;
	}

	public  void setManuFactureDate(Date manufactured) {
		this.manufactured = manufactured;
	}

	@Override
	public final String priceTag() {
		return getName() 
				+ " (used) $ " 
				+ String.format("%.2f", getPrice())
				+ " (Manufacture date: " 
				+ sdf.format(getManufactured()) 
				+ ")";
	}

}
