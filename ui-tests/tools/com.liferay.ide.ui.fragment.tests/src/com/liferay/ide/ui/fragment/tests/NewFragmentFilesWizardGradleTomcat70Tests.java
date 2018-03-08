/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.ide.ui.fragment.tests;

import com.liferay.ide.ui.fragment.tests.base.NewFragmentFilesWizardGradleBase;
import com.liferay.ide.ui.liferay.support.server.PureTomcat70Support;
import com.liferay.ide.ui.liferay.support.server.Tomcat7xSupport;
import com.liferay.ide.ui.liferay.util.RuleUtil;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;

/**
 * @author Vicky Wang
 * @author Sunny Shi
 * @author Rui Wang
 */
public class NewFragmentFilesWizardGradleTomcat70Tests extends NewFragmentFilesWizardGradleBase {

	public static PureTomcat70Support tomcat = new PureTomcat70Support(bot);

	@ClassRule
	public static RuleChain chain = RuleUtil.getRuleChain(tomcat, new Tomcat7xSupport(bot, tomcat));

	@Test
	public void addFragmentFilesShortcuts() {
		super.addFragmentFilesShortcuts();
	}

	@Test
	public void addFragmentJspfFiles() {
		super.addFragmentJspfFiles();
	}

	@Test
	public void addFragmentJspFiles() {
		super.addFragmentJspFiles();
	}

	@Test
	public void addFragmentPortletPropertiesFiles() {
		super.addFragmentPortletPropertiesFiles();
	}

	@Test
	public void addFragmentResourceActionFiles() {
		super.addFragmentResourceActionFiles();
	}

	@Test
	public void testFragmentFilesWithDeleteFuction() {
		super.addFragmentFilesShortcuts();
	}

}