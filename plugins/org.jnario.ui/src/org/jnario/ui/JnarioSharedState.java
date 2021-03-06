/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.ui;
import static com.google.inject.name.Names.named;

import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceStoreAccessImpl;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences.Initializer;
import org.jnario.ui.internal.JnarioActivator;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Module;


@SuppressWarnings("restriction")
public class JnarioSharedState implements Module {

	public void configure(Binder binder) {
		binder.bind(EclipseOutputConfigurationProvider.class).toInstance(injector().getInstance(EclipseOutputConfigurationProvider.class));
		binder.bind(IPreferenceStoreAccess.class).toInstance(injector().getInstance(PreferenceStoreAccessImpl.class));
		binder.bind(IPreferenceStoreInitializer.class)
				.annotatedWith(named("RefactoringPreferences"))
						.toInstance(injector().getInstance(Initializer.class));
		binder.bind(IPreferenceStoreInitializer.class)
				.annotatedWith(named("builderPreferenceInitializer")).toInstance(
						injector().getInstance(BuilderPreferenceAccess.Initializer.class));

	}

	protected Injector injector() {
		return JnarioActivator.getInstance().getInjector();
	}

}
