package tn.esprit.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.repository.CreditRepository;

@Service
public class CreditServiceImpl implements CreditService{
	
	@Autowired 
	CreditRepository creditRep;
	
	private static final Logger logger = LogManager.getLogger(CreditServiceImpl.class);
	
	@Override
	public float getTMM() {
		Document doc = null;

		try {
			doc = Jsoup.connect("https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105").get();
		} catch (IOException e) {
			logger.error("ERROR : " + e.getStackTrace());
			e.printStackTrace();
		}

		Elements repositories = doc.getElementsByClass("t-right");
		logger.info("INFO : +Element+ = " + repositories.get(47).text());

		String tauxTmmStr = repositories.get(47).text().replace(',', '.');
		float tauxTmmFloat = Float.parseFloat(tauxTmmStr);
		return tauxTmmFloat;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public CreditRepository getCreditRep() {
		return creditRep;
	}

	public void setCreditRep(CreditRepository creditRep) {
		this.creditRep = creditRep;
	}
	
}
