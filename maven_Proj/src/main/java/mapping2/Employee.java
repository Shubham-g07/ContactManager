package mapping2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	private int emp_id;
	private String name;
	
	@ManyToMany
	@JoinTable
	(
			// this for changing the name of the entire table that showing the id of tmp associated with projects
			name = "Emp_Proj_Id",
			// changing name of the column of employee id in the table
			joinColumns = {@JoinColumn(name = "eId") },
			// the other column known as inverse join column
			//changing name of the inverse column of project id in the table
			inverseJoinColumns = { @JoinColumn(name = "pId") }
	)
	private List<Project> projects;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String name, List<Project> projects) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.projects = projects;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", projects=" + projects + "]";
	}
	
	
	
}
