package domain.user.student;

public class Student {
	private StudentId studentId;
	private String name;
	private String lastName;
	private String matricule;
	private String dateOfBirth;
	private String placeOfBirth;
	private String phoneNumber;
	private String nationality;
	private String sanitarySituation;
	private String address;
	private String type; // affecté ou non affecté
	private String fatherPhoneNumber;
	private String fatherCellPhoneNumber;
	private String motherCellPhoneNumber;
	private String motherPhoneNumber;
	private String tutor;
	private String tutorPhoneNumber;
	private String sex;

	public Student(StudentId studentId, String name, String lastName, String matricule, String dateOfBirth, String placeOfBirth, String sex, String phoneNumber, String nationality, String sanitarySituation, String address, String type, String fatherPhoneNumber, String fatherCellPhoneNumber, String motherCellPhoneNumber, String motherPhoneNumber, String tutor, String tutorPhoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.matricule = matricule;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.sanitarySituation = sanitarySituation;
		this.address = address;
		this.type = type;
		this.fatherPhoneNumber = fatherPhoneNumber;
		this.fatherCellPhoneNumber = fatherCellPhoneNumber;
		this.motherCellPhoneNumber = motherCellPhoneNumber;
		this.motherPhoneNumber = motherPhoneNumber;
		this.tutor = tutor;
		this.tutorPhoneNumber = tutorPhoneNumber;
		this.studentId = studentId;
		this.sex = sex;
	}

	public StudentId getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public String getSanitarySituation() {
		return sanitarySituation;
	}

	public String getAddress() {
		return address;
	}

	public String getType() {
		return type;
	}

	public String getFatherPhoneNumber() {
		return fatherPhoneNumber;
	}

	public String getFatherCellPhoneNumber() {
		return fatherCellPhoneNumber;
	}

	public String getMotherCellPhoneNumber() {
		return motherCellPhoneNumber;
	}

	public String getMotherPhoneNumber() {
		return motherPhoneNumber;
	}

	public String getTutor() {
		return tutor;
	}

	public String getTutorPhoneNumber() {
		return tutorPhoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public String getMatricule() {
		return matricule;
	}

}
