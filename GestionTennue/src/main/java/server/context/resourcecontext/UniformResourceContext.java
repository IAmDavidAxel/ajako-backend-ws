package server.context.resourcecontext;

import api.uniform.UniformJsonResource;
import api.uniform.UniformResource;
import application.service.uniform.UniformService;
import domain.uniform.UniformFactory;
import domain.uniform.UniformIdFactory;
import domain.uniform.UniformRepository;
import utility.servicelocator.ServiceLocator;

public class UniformResourceContext {

	public static UniformResource create(){
		UniformRepository uniformRepository = ServiceLocator.INSTANCE.resolve(UniformRepository.class);

		UniformIdFactory uniformIdFactory = new UniformIdFactory();
		UniformFactory uniformFactory = new UniformFactory(uniformIdFactory);

		UniformService uniformService = new UniformService(uniformRepository,uniformFactory);


		return new UniformJsonResource(uniformService);
	}
}
