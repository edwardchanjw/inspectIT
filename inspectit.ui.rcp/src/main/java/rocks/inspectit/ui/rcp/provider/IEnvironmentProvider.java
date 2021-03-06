package rocks.inspectit.ui.rcp.provider;

import rocks.inspectit.shared.cs.ci.Environment;

/**
 * Interface for {@link Environment} provider. Note that this interface extends the
 * {@link ICmrRepositoryProvider} which in fact denotes to which CMR environment belongs.
 * 
 * @author Ivan Senic
 * 
 */
public interface IEnvironmentProvider extends ICmrRepositoryProvider {

	/**
	 * Returns {@link Environment}.
	 * 
	 * @return Returns {@link Environment}.
	 */
	Environment getEnvironment();
}
