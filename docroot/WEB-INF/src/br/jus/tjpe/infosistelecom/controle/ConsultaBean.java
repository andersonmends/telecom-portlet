package br.jus.tjpe.infosistelecom.controle;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import br.jus.tjpe.infosistelecom.dao.LogDao;
import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.LogDaoFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Log;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class ConsultaBean {

	private ArrayList<Ramal> ramais;
	private Ramal selectRamal;
	private Ramal ramalTemp = new Ramal();
	private Log log = new Log();

	public Ramal getSelectRamal() {
		return selectRamal;
	}

	public void setSelectRamal(Ramal selectRamal) {
		this.selectRamal = selectRamal;
	}

	public ArrayList<Ramal> getRamais() {
		return ramais;
	}

	public void setRamais(ArrayList<Ramal> ramais) {
		this.ramais = ramais;
	}

	@PostConstruct
	public void init() {

		RamalDao dao = RamalDaoFactory.createRamalDao();
		ramais = dao.listarTudo();

		// recupera a hora de acordo com o servidor TOMCAT, por�m n�o sei o
		// motivo est� retornando a hora de fuso hor�rio (timezone) diferente
		Date data = new Date();

		// formatador de data do tipo Date, onde os parametros yyyy, MM, etc,
		// s�o identificadores definidos na classe, ent�o para outras
		// formata��es, � necess�rio verificar a documenta��o da classe
		SimpleDateFormat formatDate = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		// timezone define um timezone para a classe Calendar, como est� meio
		// que com bug o TOMCAT, utilizei outra forma de recuperar a data que
		// preciso
		TimeZone timeZone = TimeZone.getTimeZone("America/Recife");
		Calendar c1 = Calendar.getInstance(timeZone);
		c1.setTimeZone(timeZone);

		// criando Date utilizei os metodos decripitadors, porque foi a �nica
		// maneira que encontrei de recuperar a data para ser formatada pelo
		// SimpleDateFormat, uma vez que usando c1.getTime n�o estava retonando
		// o novo timezone que define em 72.
		data = c1.getTime();
		data.setHours(c1.get(Calendar.HOUR_OF_DAY));
		data.setMinutes(c1.get(Calendar.MINUTE));
		data.setSeconds(c1.get(Calendar.SECOND));
		String dataFormatada = formatDate.format(data);

		System.out.println(dataFormatada);

	}

	public void atualizar() {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Campo Atualizado"));
		RamalDao daoRamal = RamalDaoFactory.createRamalDao();
		daoRamal.atualizar(selectRamal);

		log.setCategoriaNew(selectRamal.getCategoria());
		log.setCompartilhadoComNew(selectRamal.getCompartilhadoCom());
		log.setDivulgacaoNew(selectRamal.getDivulgacao());
		log.setFaxNew(selectRamal.getFax());
		log.setLocalDeInstalacaoDiferenteDaOrigemNew(selectRamal
				.getLocalDeInstalacaoDiferenteDaOrigem());
		log.setObservacoesNew(selectRamal.getObservacoes());
		log.setTipoAparelhoNew(selectRamal.getTipoAparelho());

		LogDao daoLog = LogDaoFactory.createLogDaoFactory();
		daoLog.adicionar(log);

	}

	public void cancelar() {

		this.init();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("A��o Cancelada"));
		ramalTemp = new Ramal();
	}

	public void onRowSelect(SelectEvent event) throws PortalException,
			SystemException {

		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		long userId = liferayFacesContext.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);

		// recupera a hora de acordo com o servidor TOMCAT, por�m n�o sei o
		// motivo est� retornando a hora de fuso hor�rio (timezone) diferente
		Date data = new Date();

		// formatador de data do tipo Date, onde os parametros yyyy, MM, etc,
		// s�o identificadores definidos na classe, ent�o para outras
		// formata��es, � necess�rio verificar a documenta��o da classe
		SimpleDateFormat formatDate = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		// timezone define um timezone para a classe Calendar, como est� meio
		// que com bug o TOMCAT, utilizei outra forma de recuperar a data que
		// preciso
		TimeZone timeZone = TimeZone.getTimeZone("America/Recife");
		Calendar c1 = Calendar.getInstance(timeZone);
		c1.setTimeZone(timeZone);

		// criando Date utilizei os metodos decripitadors, porque foi a �nica
		// maneira que encontrei de recuperar a data para ser formatada pelo
		// SimpleDateFormat, uma vez que usando c1.getTime n�o estava retonando
		// o novo timezone que define em 72.
		data = c1.getTime();
		data.setHours(c1.get(Calendar.HOUR_OF_DAY));
		data.setMinutes(c1.get(Calendar.MINUTE));
		data.setSeconds(c1.get(Calendar.SECOND));
		String dataFormatada = formatDate.format(data);

		ramalTemp = (Ramal) event.getObject();

		log.setFoneRamal(ramalTemp.getFone());
		log.setData(dataFormatada);
		log.setUsuario(user.getFullName());
		log.setCategoriaOld(ramalTemp.getCategoria());
		log.setCompartilhadoComOld(ramalTemp.getCompartilhadoCom());
		log.setDivulgacaoOld(ramalTemp.getDivulgacao());
		log.setFaxOld(ramalTemp.getFax());
		log.setLocalDeInstalacaoDiferenteDaOrigemOld(ramalTemp
				.getLocalDeInstalacaoDiferenteDaOrigem());
		log.setObservacoesOld(ramalTemp.getObservacoes());
		log.setTipoAparelhoOld(ramalTemp.getTipoAparelho());

	}

}
