package middleware.authentication;

import application.service.authentication.AuthenticationService;
import utility.serviceLocator.ServiceLocator;
import utility.token.AccessTokenHeaderExtractor;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class NeedAuthenticationProcessor  implements DynamicFeature {


	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		if (resourceInfo.getResourceMethod().isAnnotationPresent(NeedAuthentication.class)) {
			AuthenticationService authenticationService = ServiceLocator.INSTANCE.resolve(AuthenticationService.class);
			AccessTokenHeaderExtractor tokenExtractor  = new AccessTokenHeaderExtractor();

			context.register(new AuthenticationMiddleware(authenticationService, tokenExtractor));
		}
	}
}
