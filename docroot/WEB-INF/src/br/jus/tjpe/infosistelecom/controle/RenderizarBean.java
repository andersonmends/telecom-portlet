package br.jus.tjpe.infosistelecom.controle;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;

import com.liferay.portal.theme.ThemeDisplay;


import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class RenderizarBean {

	public String page() throws PortalException, SystemException {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		ThemeDisplay themeDisplay = liferayFacesContext.getThemeDisplay();
		Layout portalPage = themeDisplay.getLayout();
		String portalPageName = portalPage.getName(Locale.US);

		System.out.println(portalPageName + ".xhtml");
		

		
		return portalPageName + ".xhtml";
		
		
	}

}
