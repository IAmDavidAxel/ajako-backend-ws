package infrastructure.persistence.dao.user.student;

import infrastructure.persistence.dao.DaoInternalException;
import infrastructure.persistence.dao.sqlite.builder.DaoEntityNotFoundException;
import infrastructure.persistence.dao.sqlite.builder.SqliteBuilder;
import infrastructure.persistence.dto.StudentDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentSqliteDao implements StudentDao {
	private SqliteConnection connection;

	public StudentSqliteDao(SqliteConnection sqliteConnection) {
		this.connection = sqliteConnection;
	}

	@Override
	public void save(StudentDto studentDto) throws DaoInternalException {
		SqliteBuilder builder = new SqliteBuilder(connection);
		builder.ReplaceInto("eleve")
				.Columns("id_eleve","mat","nom_elv","pre_elv","dn","ln","gen","tel","nat","sit_sanit","address","type","np_per","tel_per","np_mer","tel_mer","tuteur","tel_tuteur")
				.Values(studentDto.getId(),
						studentDto.getMatricule(),
						studentDto.getName(),
						studentDto.getLastName(),
						studentDto.getDateOfBirth(),
						studentDto.getPlaceOfBirth(),
						studentDto.getSex(),
						studentDto.getNationality(),
						studentDto.getPhoneNumber(),
						studentDto.getSanitarySituation(),
						studentDto.getAddress(),
						studentDto.getType(),
						studentDto.getFatherCellPhoneNumber(),
						studentDto.getFatherPhoneNumber(),
						studentDto.getMotherCellPhoneNumber(),
						studentDto.getMotherPhoneNumber(),
						studentDto.getTutor(),
						studentDto.getTutorPhoneNumber())
				.Execute();
	}

	@Override
	public List<StudentDto> findAll() throws DaoInternalException, DaoEntityNotFoundException {
		SqliteBuilder builder = new SqliteBuilder(connection);

		List<Map<String,Object>> results = builder
				.SelectAll()
				.From("eleve")
				.FetchAll();

		List<StudentDto> studentDtos = new ArrayList<>();
		for (Map<String, Object> result: results){
			StudentDto studentDto = createStudentDto(result);
			studentDtos.add(studentDto);
		}

		return studentDtos;
	}

	private StudentDto createStudentDto(Map<String, Object> result) {
		StudentDto studentDto = new StudentDto();

		String id  = (String) result.get("id_eleve");
		String matricule = (String) result.get("mat");
		String name = (String) result.get("nom_elv");
		String lastName = (String) result.get("pre_elv");
		String sex = (String) result.get("gen");
		String phoneNumber = (String) result.get("tel");
		String sanitarySituation = (String) result.get("sit_sanit");
		String fatherCellPhoneNumber = (String) result.get("np_per");
		String fatherPhoneNumber = (String) result.get("tel_per");
		String motherCellPhoneNumber = (String) result.get("np_mer");
		String motherPhoneNumber = (String) result.get("tel_mer");
		String tutor = (String) result.get("tuteur");
		String tutorPhoneNumber =(String) result.get("tel_tuteur");
		String address = (String) result.get("address");
		String dateOfBirth = (String) result.get("dn");
		String placeOfBirth = (String) result.get("ln");
		String type = (String) result.get("type");
		String nationality =(String) result.get("nat");


		studentDto.setNationality(nationality);
		studentDto.setType(type);
		studentDto.setDateOfBirth(dateOfBirth);
		studentDto.setPlaceOfBirth(placeOfBirth);
		studentDto.setId(id);
		studentDto.setName(name);
		studentDto.setLastName(lastName);
		studentDto.setMatricule(matricule);
		studentDto.setSanitarySituation(sanitarySituation);
		studentDto.setSex(sex);
		studentDto.setPhoneNumber(phoneNumber);
		studentDto.setFatherCellPhoneNumber(fatherCellPhoneNumber);
		studentDto.setFatherPhoneNumber(fatherPhoneNumber);
		studentDto.setMotherCellPhoneNumber(motherCellPhoneNumber);
		studentDto.setMotherPhoneNumber(motherPhoneNumber);
		studentDto.setTutor(tutor);
		studentDto.setTutorPhoneNumber(tutorPhoneNumber);
		studentDto.setAddress(address);

		return studentDto;
	}
}
