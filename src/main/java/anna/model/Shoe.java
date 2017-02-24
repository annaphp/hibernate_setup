package anna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Shoe {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
    
    @Column
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

	public void setId(long id){
		this.id = id;
		
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

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", color=" + color + ", size=" + size + "]";
	}	
	
	
	
}
