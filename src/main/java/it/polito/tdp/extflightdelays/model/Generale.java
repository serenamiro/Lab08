package it.polito.tdp.extflightdelays.model;

public class Generale {
	
	private Airport ap;
	private Airport aa;
	private int avgDist;
	
	public Generale(Airport ap, Airport aa, int avgDist) {
		this.ap = ap;
		this.aa = aa;
		this.avgDist = avgDist;
	}

	public Airport getAp() {
		return ap;
	}

	public void setAp(Airport ap) {
		this.ap = ap;
	}

	public Airport getAa() {
		return aa;
	}

	public void setAa(Airport aa) {
		this.aa = aa;
	}

	public int getAvgDist() {
		return avgDist;
	}

	public void setAvgDist(int avgDist) {
		this.avgDist = avgDist;
	}

	@Override
	public String toString() {
		return ap.getId()+" "+aa.getId()+" "+avgDist;
	}
	
	
	

}
