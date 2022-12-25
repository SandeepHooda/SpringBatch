package sandeep.SpringBatch.step;

import org.springframework.batch.item.ItemProcessor;

import sandeep.SpringBatch.vo.Employee;

public class Processor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee data) throws Exception {
		data.setEmailAddress(data.getEmailAddress().toUpperCase());
		return data;
	}

}
