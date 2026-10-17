package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import repository.*;

public class ReadEmployees {

	public static Employee parseEmployee(String line) throws EmployeeParsingException{
		String[] parts = line.split(",");
		if(parts.length != 4) {
			throw new EmployeeParsingException("Wrong number of fields: " + line);
		}
		try {
            String dept = parts[0].trim();
			int number = Integer.parseInt(parts[1].trim());
			String name = parts[2].trim();
			int salary = Integer.parseInt(parts[3].trim());
			if(dept.isEmpty() || name.isEmpty()) {
				throw new EmployeeParsingException("Wrong dept or name in line " + line);
			}
			return new Employee(new EmployeeId(dept, number), name, salary);
		}catch (NumberFormatException e) {
			throw new EmployeeParsingException("Bad number in line: " + line);
		}
	}

	public static void main(String[] args) {
		Repository<EmployeeId, Employee> repo = new Repository<>();

		try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))){
			String line = br.readLine();
			while((line = br.readLine()) != null) {
				try{
					repo.save(parseEmployee(line));
				}catch (EmployeeParsingException e) {
					System.out.println("Skipping Line: " + e.getMessage());
				}
			}

        }catch(IOException e){
			System.out.println("Error reading file: " + e.getMessage());
		}

		for(Employee e: repo.findAll(emp -> true)){
			System.out.println(e);
		}
		System.out.println(repo.findAll(e -> e.getSalary() > 100000).size());

	}

}
