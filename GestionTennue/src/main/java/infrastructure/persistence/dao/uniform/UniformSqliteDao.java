package infrastructure.persistence.dao.uniform;

import domain.uniform.SousType;
import domain.uniform.Type;
import infrastructure.persistence.dao.DaoInternalException;
import infrastructure.persistence.dao.sqlite.builder.DaoEntityNotFoundException;
import infrastructure.persistence.dao.sqlite.builder.SqliteBuilder;
import infrastructure.persistence.dto.UniformDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import org.sqlite.SQLiteConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UniformSqliteDao implements UniformDao {

	private SqliteConnection connection;

	public UniformSqliteDao (SqliteConnection connection){
		this.connection = connection;
	}

	@Override
	public void save(UniformDto uniformDto) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);

		sqliteBuilder.ReplaceInto("uniform")
				.Columns("uniform_id","size","type","sous_type","price")
				.Values(uniformDto.getId(),
						uniformDto.getSize(),
						uniformDto.getType(),
						uniformDto.getSousType(),
						uniformDto.getPrice())
				.Execute();
	}

	@Override
	public List<UniformDto> findAll() throws DaoInternalException, DaoEntityNotFoundException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(connection);

		List<Map<String,Object>> results = sqliteBuilder
				.SelectAll()
				.From("uniform")
				.FetchAll();

		List<UniformDto> uniformDtos = new ArrayList<>();
		for (Map<String,Object> result : results){
			UniformDto uniformDto = createUniformDto(result);
			uniformDtos.add(uniformDto);
		}

		return uniformDtos;
	}

	private UniformDto createUniformDto(Map<String, Object> result) {

		String id = (String) result.get("uniform_id");
		int size = (int) result.get("size");
		Type type = Type.valueOf((String) result.get("type"));
		SousType sousType = SousType.valueOf((String) result.get("sous_type"));


		UniformDto uniformDto = new UniformDto();
		uniformDto.setId(id);
		uniformDto.setType(type);
		uniformDto.setSousType(sousType);
		uniformDto.setSize(size);


		return uniformDto;
	}


}
