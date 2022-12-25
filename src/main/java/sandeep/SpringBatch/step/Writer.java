package sandeep.SpringBatch.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import sandeep.SpringBatch.vo.Employee;

public class Writer implements ItemWriter<Employee> {

	@Override
	public void write(List<? extends Employee> messages) throws Exception {
		for (Employee msg : messages) {
			System.out.println("Writing the data " + msg.getEmailAddress());
		}
	}

}