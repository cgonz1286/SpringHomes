package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="homes")
public class Home {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int houseSqFt;
	private int beds;
	private double baths;
	private String type;
	private String yearBuilt;
	
	public Home() {
		super();
		this.houseSqFt = 0;
		this.beds = 0;
		this.baths = 0;
		this.type = "";
		this.yearBuilt = "";
	}
	
	public Home(int houseSqFt, int beds, double baths, String type, String yearBuilt) {
		super();
		this.houseSqFt = houseSqFt;
		this.beds = beds;
		this.baths = baths;
		this.type = type;
		this.yearBuilt = yearBuilt;
	}
	
	public Home(long id, int houseSqFt, int beds, double baths, String type, String yearBuilt) {
		super();
		this.id = id;
		this.houseSqFt = houseSqFt;
		this.beds = beds;
		this.baths = baths;
		this.type = type;
		this.yearBuilt = yearBuilt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getHouseSqFt() {
		return houseSqFt;
	}

	public void setHouseSqFt(int houseSqFt) {
		this.houseSqFt = houseSqFt;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public double getBaths() {
		return baths;
	}

	public void setBaths(double baths) {
		this.baths = baths;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(String yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	@Override
	public String toString() {
		return "Home [id=" + id + ", houseSqFt=" + houseSqFt + ", beds=" + beds + 
			   ", baths=" + baths + ", type=" + type + ", yearBuilt=" + yearBuilt + "]";
	}
	
}
