import java.io.IOException;

public class Worker extends Human{

	public Worker(Sex sex, String name, String surname) {
		super(sex, name, surname);
		}
	int salary;
	
	public int getSalary(){
		return this.salary; 
		
	}
	public void setSalary(int salary){
		this.salary=salary;
		
	}
	
	public String getName() {
        return "worker" + super.getName();
	}


}


