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

package com.liferay.ide.kaleo.ui.diagram;

import com.liferay.ide.kaleo.ui.editor.WorkflowDefinitionEditor;

import org.eclipse.sapphire.ui.ISapphirePart;
import org.eclipse.sapphire.ui.Presentation;
import org.eclipse.sapphire.ui.SapphireAction;
import org.eclipse.sapphire.ui.SapphireActionHandler;
import org.eclipse.sapphire.ui.def.ActionHandlerDef;
import org.eclipse.sapphire.ui.def.SapphireActionType;
import org.eclipse.ui.IPropertyListener;

/**
 * @author Gregory Amerson
 */
public class UseNodeWizardsActionHandler extends SapphireActionHandler {

	@Override
	public void init(SapphireAction action, ActionHandlerDef def) {
		super.init(action, def);

		if (action.getType() == SapphireActionType.TOGGLE) {
			ISapphirePart diagramPart = getPart();

			WorkflowDefinitionEditor definitionEditor = diagramPart.adapt(WorkflowDefinitionEditor.class);

			if (definitionEditor != null) {
				setChecked(definitionEditor.isNodeWizardsEnabled());

				definitionEditor.addPropertyListener(
					new IPropertyListener() {

						public void propertyChanged(Object source, int propId) {
							if (propId == WorkflowDefinitionEditor.PROP_NODE_WIZARDS_ENABLED) {
								setChecked(definitionEditor.isNodeWizardsEnabled());
							}
						}

					});
			}
		}
	}

	@Override
	protected Object run(Presentation context) {
		ISapphirePart part = context.part();

		WorkflowDefinitionEditor definitionEditor = part.adapt(WorkflowDefinitionEditor.class);

		definitionEditor.setNodeWizardsEnabled(isChecked());

		return null;
	}

}