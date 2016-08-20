package pack.entity;

public class Coordinate {
	private Integer coordinateId;
	public Integer getCoordinateId() {
		return coordinateId;
	}
	public void setCoordinateId(Integer coordinateId) {
		this.coordinateId = coordinateId;
	}
	private Double abscissa;
	private Double ordinate;
	public Coordinate(){}
	public Coordinate(Double abscissa,Double ordinate){
		this.abscissa=abscissa;
		this.ordinate=ordinate;
	}
	public Double getAbscissa() {
		return abscissa;
	}
	public void setAbscissa(Double abscissa) {
		this.abscissa = abscissa;
	}
	public Double getOrdinate() {
		return ordinate;
	}
	public void setOrdinate(Double ordinate) {
		this.ordinate = ordinate;
	}
	
}
