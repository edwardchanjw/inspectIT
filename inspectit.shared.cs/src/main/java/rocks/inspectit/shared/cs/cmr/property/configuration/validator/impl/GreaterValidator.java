package rocks.inspectit.shared.cs.cmr.property.configuration.validator.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.hamcrest.Matchers;

import rocks.inspectit.shared.cs.cmr.property.configuration.SingleProperty;
import rocks.inspectit.shared.cs.cmr.property.configuration.validation.PropertyValidation;
import rocks.inspectit.shared.cs.cmr.property.configuration.validation.ValidationError;
import rocks.inspectit.shared.cs.cmr.property.configuration.validator.AbstractComparingValidator;

/**
 * Is greater than validator.
 * 
 * @author Ivan Senic
 * 
 * @param <T>
 *            Type of values to compare.
 */
@XmlRootElement(name = "isGreater")
public class GreaterValidator<T extends Number> extends AbstractComparingValidator<T> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void compare(SingleProperty<? extends T> property, SingleProperty<? extends T> againstProperty, T value, T against, PropertyValidation propertyValidation) {
		if (!matches(value, against)) {
			List<SingleProperty<?>> properties = new ArrayList<SingleProperty<?>>(2);
			properties.add(property);
			properties.add(againstProperty);
			ValidationError validationError = new ValidationError(properties, "Value of property '" + property.getName() + "' must be greater than value of property '" + againstProperty.getName()
					+ "'");
			propertyValidation.addValidationError(validationError);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void compare(SingleProperty<? extends T> property, T value, T against, PropertyValidation propertyValidation) {
		if (!matches(value, against)) {
			ValidationError validationError = new ValidationError(Collections.<SingleProperty<?>> singletonList(property), "Value of property '" + property.getName() + "' must be greater than "
					+ against);
			propertyValidation.addValidationError(validationError);
		}
	}

	/**
	 * Executes compare.
	 * 
	 * @param value
	 *            Value.
	 * @param against
	 *            Value to compare against.
	 * @return Returns true if match was valid.
	 */
	private boolean matches(T value, T against) {
		return Matchers.greaterThan(against.doubleValue()).matches(value.doubleValue());
	}

}
