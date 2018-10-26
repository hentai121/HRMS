/**
 * 
 */
package com.fdzcxy.hrms.ui;

import com.fdzcxy.hrms.exception.UnsupportedUITypeException;

/**
 * @author uerax
 *
 */
public class UIFactory {
	public static BaseUI getUI(UIType type) {

		BaseUI ui = null;

		if (type.equals(UIType.MainMenu))
			ui = new MainMenuUI();
		else if (type.equals(UIType.EmpOuter))
			ui = new EmpOuterUI();
		else if (type.equals(UIType.FormatEmpOuter))
			ui = new FormatEmpOuterUI();
		else if (type.equals(UIType.ShortOuter))
			ui = new ShortOuterUI();
		else if (type.equals(UIType.FormatShortOuter))
			ui = new FormatShortOuterUI();
		else if (type.equals(UIType.SerchEmp))
			ui = new SerchEmpUI();
		else if (type.equals(UIType.AddEmp))
			ui = new AddEmpUI();
		else if (type.equals(UIType.DeleteEmp))
			ui = new DeleteEmpUI();
		else
			throw new UnsupportedUITypeException("invalid UI type found!");

		return ui;

	}
}
