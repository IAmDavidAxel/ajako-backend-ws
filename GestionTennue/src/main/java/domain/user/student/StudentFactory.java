package domain.user.student;

import api.dto.user.student.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentFactory {

	private StudentIdFactory studentIdFactory;

	public StudentFactory(StudentIdFactory studentIdFactory) {
		this.studentIdFactory = studentIdFactory;
	}

	public Student create(StudentDto studentDto) {
		StudentId id = studentIdFactory.create();

		String name = studentDto.getName();
		String lastName = studentDto.getLastName();
		String dateOfBirth = studentDto.getDateOfBirth();
		String placeOfBirth = studentDto.getPlaceOfBirth();
		String sex =studentDto.getSex();
		String nationality = studentDto.getNationality();
		String sitSanit = studentDto.getSitSanit();
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

	public StudentDto create(Student student) {
		StudentDto studentDto = new StudentDto();

		studentDto.setName(student.getName());
		studentDto.setLastName(student.getLastName());
		studentDto.setDateOfBirth(student.getDateOfBirth());
		studentDto.setPlaceOfBirth(student.getPlaceOfBirth());
		studentDto.setSex(student.getSex());
		studentDto.setPhoneNumber(student.getPhoneNumber());
		studentDto.setNationality(student.getNationality());
		studentDto.setSitSanit(student.getSanitarySituation());
		studentDto.setAddress(student.getAddress());
		studentDto.setFatherCellPhoneNUmber(student.getFatherCellPhoneNumber());
		studentDto.setFatherPhoneNumber(student.getFatherPhoneNumber());
		studentDto.setMotherPhoneNumber(student.getMotherPhoneNumber());
		studentDto.setMotherCellPhoneNumber(student.getMotherCellPhoneNumber());
		studentDto.setTutor(student.getTutor());
		studentDto.setTutorPhoneNumber(student.getTutorPhoneNumber());
		studentDto.setType(student.getType());
		studentDto.setMatricule(student.getMatricule());

		return studentDto;
	}

	public List<StudentDto> createList(List<Student> students) {
		return students.stream().map(this::create).collect(Collectors.toList());
	}
}
