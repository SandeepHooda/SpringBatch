package sandeep.SpringBatch.config;

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
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import sandeep.SpringBatch.vo.Employee;

@Configuration
public class BatchContext {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Bean
	public FlatFileItemReader itemReader() {
		FlatFileItemReader reader = new FlatFileItemReader();
		//Resource resource = resourceLoader.getResource("\\Users\\sonuh\\software\\eclipse-workspace\\SpringBatch\\src\\main\\resources\\employee.csv");
		reader.setLineMapper(lineMapper());
		reader.setResource((new ClassPathResource("employee.csv")));
		return reader;
		
	}
	
	public DefaultLineMapper<Employee> lineMapper(){
		
		 DefaultLineMapper<Employee> studentLineMapper = new DefaultLineMapper<>();
		 
	        LineTokenizer studentLineTokenizer = createStudentLineTokenizer();
	        studentLineMapper.setLineTokenizer(studentLineTokenizer);
	 
	        FieldSetMapper<Employee> studentInformationMapper =
	                createStudentInformationMapper();
	        studentLineMapper.setFieldSetMapper(studentInformationMapper);
	 
	        return studentLineMapper;
		
	}
	
	private LineTokenizer createStudentLineTokenizer() {
        DelimitedLineTokenizer studentLineTokenizer = new DelimitedLineTokenizer();
        studentLineTokenizer.setDelimiter(",");
        studentLineTokenizer.setNames(new String[]{
                "name", 
                "emailAddress", 
                "purchasedPackage"
        });
        return studentLineTokenizer;
    }
 
    private FieldSetMapper<Employee> createStudentInformationMapper() {
        BeanWrapperFieldSetMapper<Employee> studentInformationMapper =
                new BeanWrapperFieldSetMapper<>();
        studentInformationMapper.setTargetType(Employee.class);
        return studentInformationMapper;
    }

}
