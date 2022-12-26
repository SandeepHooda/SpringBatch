package sandeep.SpringBatch.step;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import sandeep.SpringBatch.vo.Employee;

@Configuration
public class Reader {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Bean
	public FlatFileItemReader itemReader() {
		FlatFileItemReader reader = new FlatFileItemReader();
		reader.setLineMapper(lineMapper());
		reader.setResource((new ClassPathResource("employee.csv")));
		return reader;
		
	}
	
	public DefaultLineMapper<Employee> lineMapper(){
		
		 DefaultLineMapper<Employee> employeeLineMapper = new DefaultLineMapper<>();
		 
	        employeeLineMapper.setLineTokenizer(createEmployeeLineTokenizer());
	 
	        employeeLineMapper.setFieldSetMapper(createEmployeeInformationMapper());
	 
	        return employeeLineMapper;
		
	}
	
	private LineTokenizer createEmployeeLineTokenizer() {
        DelimitedLineTokenizer employeeLineTokenizer = new DelimitedLineTokenizer();
        employeeLineTokenizer.setDelimiter(",");
        employeeLineTokenizer.setNames(new String[]{
                "name", 
                "emailAddress", 
                "purchasedPackage"
        });
        return employeeLineTokenizer;
    }
 
    private FieldSetMapper<Employee> createEmployeeInformationMapper() {
        BeanWrapperFieldSetMapper<Employee> employeeInformationMapper =     new BeanWrapperFieldSetMapper<>();
        employeeInformationMapper.setTargetType(Employee.class);
        return employeeInformationMapper;
    }

}
