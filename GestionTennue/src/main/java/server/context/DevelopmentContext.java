package server.context;

import api.uniform.UniformResource;
import api.user.student.StudentResource;
import domain.uniform.UniformRepository;
import domain.user.student.StudentRepository;
import infrastructure.persistence.assembler.uniform.UniformAssembler;
import infrastructure.persistence.assembler.user.student.StudentAssembler;
import infrastructure.persistence.dao.uniform.UniformDao;
import infrastructure.persistence.dao.uniform.UniformSqliteDao;
import infrastructure.persistence.dao.user.student.StudentDao;
import infrastructure.persistence.dao.user.student.StudentSqliteDao;
import infrastructure.persistence.entitymanager.sqlite.SqliteConnection;
import infrastructure.persistence.entitymanager.sqlite.SqliteEntityManager;
import infrastructure.persistence.repository.StudentSqliteRepository;
import infrastructure.persistence.repository.UniformSqliteRepository;
import server.context.resourcecontext.StudentResourceContext;
import server.context.resourcecontext.UniformResourceContext;
import utility.datamanager.ApplicationConfiguration;
import utility.servicelocator.ServiceLocator;

public class DevelopmentContext extends Context {
	private String databaseName;

	public DevelopmentContext(){
		this.databaseName = ApplicationConfiguration.sqliteDbName;
	}
	public DevelopmentContext(String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
	public void initializeResource() {
		/**
		 * Registering persistence infrastructure services
		 */
		UniformAssembler uniformAssembler = new UniformAssembler();
		StudentAssembler studentAssembler = new StudentAssembler();

		SqliteConnection sqliteConnection = new SqliteConnection(databaseName);
		ServiceLocator.INSTANCE.register(SqliteConnection.class,sqliteConnection);

		UniformDao uniformDao = new UniformSqliteDao(sqliteConnection);
		StudentDao studentDao = new StudentSqliteDao(sqliteConnection);


		SqliteEntityManager entityManager = new SqliteEntityManager(sqliteConnection);

		UniformSqliteRepository uniformRepository = new UniformSqliteRepository(uniformAssembler,uniformDao);
		StudentSqliteRepository studentRepository = new StudentSqliteRepository(studentAssembler,studentDao);

		ServiceLocator.INSTANCE.register(UniformRepository.class,uniformRepository);
		ServiceLocator.INSTANCE.register(StudentRepository.class,studentRepository);
	}

	@Override
	public void registerServices() {
		UniformResource uniformResource = UniformResourceContext.create();
		StudentResource studentResource = StudentResourceContext.create();

		this.resourcesContext.add(uniformResource);
		this.resourcesContext.add(studentResource);

	}
}
