package infrastructure.persistence.assembler.user.student;

import domain.user.student.Student;
import domain.user.student.StudentId;
import infrastructure.persistence.dto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentAssembler {

	public StudentDto create(Student student) {
		StudentDto studentDto = new StudentDto() ;

		studentDto.setId(student.getStudentId().getIdValue());
		studentDto.setName(student.getName());
		studentDto.setLastName(student.getLastName());
		studentDto.setDateOfBirth(student.getDateOfBirth());
		studentDto.setPlaceOfBirth(student.getPlaceOfBirth());
		studentDto.setSex(student.getSex());
		studentDto.setPhoneNumber(student.getPhoneNumber());
		studentDto.setNationality(student.getNationality());
		studentDto.setSanitarySituation(student.getSanitarySituation());
		studentDto.setAddress(student.getAddress());
		studentDto.setFatherCellPhoneNumber(student.getFatherCellPhoneNumber());
		studentDto.setFatherPhoneNumber(student.getFatherPhoneNumber());
		studentDto.setMotherPhoneNumber(student.getMotherPhoneNumber());
		studentDto.setMotherCellPhoneNumber(student.getMotherCellPhoneNumber());
		studentDto.setTutor(student.getTutor());
		studentDto.setTutorPhoneNumber(student.getTutorPhoneNumber());
		studentDto.setType(student.getType());
		studentDto.setMatricule(student.getMatricule());

		return studentDto;
	}

	public Student create(StudentDto studentDto) {
		String idValue = studentDto.getId();

		StudentId id = new StudentId();
		id.setIdValue(idValue);
		String name = studentDto.getName();
		String lastName = studentDto.getLastName();
		String dateOfBirth = studentDto.getDateOfBirth();
		String placeOfBirth = studentDto.getPlaceOfBirth();
		String sex =studentDto.getSex();
		String nationality = studentDto.getNationality();
		String sitSanit = studentDto.getSanitarySituation();
		String address = studentDto.getAddress();
		String type = studentDto.getType();
		String fatherPhoneNumber =studentDto.getFatherPhoneNumber();
		String fatherCellPhoneNumber =studentDto.getFatherCellPhoneNumber();
		String motherPhoneNumber = studentDto.getMotherPhoneNumber();
		String motherCellPhoneNumber =studentDto.getMotherCellPhoneNumber();
		String tutor = studentDto.getTutor();
		String tutorPhoneNumber = studentDto.getTutorPhoneNumber();
		String phoneNumber = studentDto.getPhoneNumber();
		String matricule = studentDto.getMatricule();

		return new Student(id,name,lastName, matricule, dateOfBirth,placeOfBirth,sex,phoneNumber,nationality,sitSanit,address,type,fatherPhoneNumber,fatherCellPhoneNumber,motherCellPhoneNumber,motherPhoneNumber,tutor,tutorPhoneNumber);
	}

	public List<Student> createList(List<StudentDto> studentDtos) {
		return studentDtos.stream().map(this::create).collect(Collectors.toList());
	}
}
