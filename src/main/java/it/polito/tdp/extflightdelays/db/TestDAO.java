package it.polito.tdp.extflightdelays.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.extflightdelays.model.Airport;
import it.polito.tdp.extflightdelays.model.Generale;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		Map<Integer, Airport> idMap =  new HashMap<Integer, Airport>();
		dao.loadAllAirports(idMap);
		//System.out.println(idMap);
		
		
		List<Generale> gen = new LinkedList<Generale>(dao.getResults(idMap, 1000));
		System.out.println(gen.size());
		for(Generale g : gen) {
			System.out.println(g.toString());
		}
		
	}

}
