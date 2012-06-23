package org.jnario;

import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.spec.tests.documentation.JnarioSpecsTutorialSpec;
import org.jnario.spec.tests.integration.AfterAllSpec;
import org.jnario.spec.tests.integration.AfterSpec;
import org.jnario.spec.tests.integration.AnnotationsSpec;
import org.jnario.spec.tests.integration.AssertionSpec;
import org.jnario.spec.tests.integration.BeforeAllSpec;
import org.jnario.spec.tests.integration.BeforeSpec;
import org.jnario.spec.tests.integration.CollectionLiteralsSpec;
import org.jnario.spec.tests.integration.ExampleGroupSpec;
import org.jnario.spec.tests.integration.ExtensionsSpec;
import org.jnario.spec.tests.integration.ImplicitSubjectSpec;
import org.jnario.spec.tests.integration.PendingSpec;
import org.jnario.spec.tests.integration.SimpleExampleSpec;
import org.jnario.spec.tests.integration.SpecInstantiationSpec;
import org.jnario.spec.tests.integration.SpecsExampleTablesSpec;
import org.jnario.spec.tests.integration.StaticImportsSpec;
import org.jnario.spec.tests.integration.ThrowsSpec;
import org.jnario.spec.tests.integration.UsingJUnitRulesSpec;
import org.jnario.spec.tests.integration.UsingShouldSpec;
import org.jnario.spec.tests.integration.UsingXtendSWithOperatorSpec;
import org.jnario.spec.tests.unit.doc.SpecDocGeneratorSpec;
import org.jnario.spec.tests.unit.naming.ExampleNameProviderSpec;
import org.jnario.spec.tests.unit.naming.ExampleSpec;
import org.jnario.spec.tests.unit.naming.OperationNameProviderSpec;
import org.jnario.spec.tests.unit.naming.SpecQualifiedNameProviderSpec;
import org.jnario.spec.tests.unit.scoping.SpecScopeProviderSpec;
import org.jnario.spec.tests.unit.validation.SpecJavaValidatorSpec;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Spec")
@Contains({ OperationNameProviderSpec.class, UsingJUnitRulesSpec.class, ExampleGroupSpec.class, CollectionLiteralsSpec.class, BeforeSpec.class, ImplicitSubjectSpec.class, SimpleExampleSpec.class, ThrowsSpec.class, SpecQualifiedNameProviderSpec.class, SpecsExampleTablesSpec.class, AssertionSpec.class, BeforeAllSpec.class, SpecInstantiationSpec.class, AfterAllSpec.class, SpecDocGeneratorSpec.class, AnnotationsSpec.class, UsingXtendSWithOperatorSpec.class, SpecScopeProviderSpec.class, UsingShouldSpec.class, JnarioSpecsTutorialSpec.class, AfterSpec.class, ExtensionsSpec.class, PendingSpec.class, StaticImportsSpec.class, ExampleNameProviderSpec.class, ExampleSpec.class, SpecJavaValidatorSpec.class })
@SuppressWarnings("all")
public class SpecSuite {
}