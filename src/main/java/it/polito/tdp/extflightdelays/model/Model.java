package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;


public class Model {
	
	public Map<Integer, Airport> idMap;
	public Graph<Airport, DefaultWeightedEdge> grafo;
	List<Generale> gen;
	
	public Model() {
		idMap = new HashMap<Integer, Airport>();
		List<Generale> gen = new LinkedList<Generale>();
	}
	
	public void creaGrafo(int distMediaMinima) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		dao.loadAllAirports(idMap);
		
		Graphs.addAllVertices(this.grafo, idMap.values());
		
		gen = dao.getResults(idMap, distMediaMinima);
		
		for (Generale g : gen) {
				Graphs.addEdge(this.grafo, g.getAp(), g.getAa(), g.getAvgDist());
			}
		
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public String stampaRisultati() {
		String s = "";
		for(Generale g : gen) {
			s += g.toString()+"\n";
		}
		return s;
	}

}
