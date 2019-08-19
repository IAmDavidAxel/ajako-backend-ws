package middleware.role;

import application.service.accessLevel.AccessLevelService;
import domain.token.TokenEncoder;
import utility.serviceLocator.ServiceLocator;
import utility.token.AccessTokenHeaderExtractor;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class HasRoleProcessor implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {

		if (resourceInfo.getResourceMethod().isAnnotationPresent(HasRole.class)) {
			HasRole hasRoleAnnotation = resourceInfo.getResourceMethod().getAnnotation(HasRole.class);
			AccessTokenHeaderExtractor tokenExtractor = new AccessTokenHeaderExtractor();
			TokenEncoder tokenEncoder = new TokenEncoder();
			AccessLevelService accessLevelService = ServiceLocator.INSTANCE.resolve(AccessLevelService.class);

			context.register(new HasRoleMiddleware(hasRoleAnnotation.role(), accessLevelService, tokenExtractor, tokenEncoder));
		}
	}
}
