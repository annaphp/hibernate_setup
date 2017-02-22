package anna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoes")
public class Shoe {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
    
    @Column(name="shoe_color", nullable = false)
	String color;
    
	int size;
	
	public Shoe() {}

	public Shoe( String color, int size) {
		this.color = color;
		this.size = size;
	}


	public long getId() {
		return id;
	}

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}	
	
}
