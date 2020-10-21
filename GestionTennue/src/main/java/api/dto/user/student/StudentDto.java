package api.dto.user.student;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDto {
	@JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
	private String name;

	@JsonProperty(value = "last_name", access = JsonProperty.Access.READ_WRITE)
	private String lastName;

	@JsonProperty(value = "matricule", access = JsonProperty.Access.READ_WRITE)
	private String matricule;

	@JsonProperty(value = "date_of_birth", access = JsonProperty.Access.READ_WRITE)
	private String dateOfBirth;

	@JsonProperty(value = "place_of_birth", access = JsonProperty.Access.READ_WRITE)
	private String placeOfBirth;

	@JsonProperty(value = "sex", access = JsonProperty.Access.READ_WRITE)
	private String sex;
	@JsonProperty(value = "nationality", access = JsonProperty.Access.READ_WRITE)
	private String nationality;

	@JsonProperty(value = "sanitary_situation", access = JsonProperty.Access.READ_WRITE)
	private String sitSanit;

	@JsonProperty(value = "address", access = JsonProperty.Access.READ_WRITE)
	private String address;

	@JsonProperty(value = "type", access = JsonProperty.Access.READ_WRITE)
	private String type;

	@JsonProperty(value = "father_phone_number", access = JsonProperty.Access.READ_WRITE)
	private String fatherPhoneNumber;

	@JsonProperty(value = "father_cell_phone_number", access = JsonProperty.Access.READ_WRITE)
	private String fatherCellPhoneNUmber;

	@JsonProperty(value = "mother_phone_number", access = JsonProperty.Access.READ_WRITE)
	private String motherPhoneNumber;

	@JsonProperty(value = "mother_cell_phone_number", access = JsonProperty.Access.READ_WRITE)
	private String motherCellPhoneNumber;

	@JsonProperty(value = "tutor", access = JsonProperty.Access.READ_WRITE)
	private String tutor;

	@JsonProperty(value = "tutor_phone_number", access = JsonProperty.Access.READ_WRITE)
	private String tutorPhoneNumber;

	@JsonProperty(value = "phone_number", access = JsonProperty.Access.READ_WRITE)
	private String phoneNumber;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getFatherCellPhoneNUmber() {
		return fatherCellPhoneNUmber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationality() {
		return nationality;
	}

	public void setSitSanit(String sitSanit) {
		this.sitSanit = sitSanit;
	}

	public String getSitSanit() {
		return sitSanit;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setFatherPhoneNumber(String fatherPhoneNumber) {
		this.fatherPhoneNumber = fatherPhoneNumber;
	}

	public String getFatherPhoneNumber() {
		return fatherPhoneNumber;
	}

	public void setFatherCellPhoneNUmber(String fatherCellPhoneNUmber) {
		this.fatherCellPhoneNUmber = fatherCellPhoneNUmber;
	}

	public String getFatherCellPhoneNumber() {
		return fatherCellPhoneNUmber;
	}

	public void setMotherPhoneNumber(String motherPhoneNumber) {
		this.motherPhoneNumber = motherPhoneNumber;
	}

	public String getMotherPhoneNumber() {
		return motherPhoneNumber;
	}

	public void setMotherCellPhoneNumber(String motherCellPhoneNumber) {
		this.motherCellPhoneNumber = motherCellPhoneNumber;
	}

	public String getMotherCellPhoneNumber() {
		return motherCellPhoneNumber;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutorPhoneNumber(String tutorPhoneNumber) {
		this.tutorPhoneNumber = tutorPhoneNumber;
	}

	public String getTutorPhoneNumber() {
		return tutorPhoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
