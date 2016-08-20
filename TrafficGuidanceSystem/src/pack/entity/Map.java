package pack.entity;

public class Map {
	private Integer mapId;
	private Integer coordinateId;
	//private Coordinate coordinate;
	
	
	
	private Integer zoom;
	public Integer getCoordinateId() {
		return coordinateId;
	}


	public void setCoordinateId(Integer coordinateId) {
		this.coordinateId = coordinateId;
	}


	public Map(){}
	
	
	/*public Map(Coordinate coordinate,Integer zoom){
		this.coordinate=coordinate;
		this.zoom=zoom;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}*/
	public Integer getZoom() {
		return zoom;
	}
	public Integer getMapId() {
		return mapId;
	}
	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}
	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}
	
}
