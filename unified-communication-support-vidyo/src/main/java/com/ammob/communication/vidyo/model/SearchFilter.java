package com.ammob.communication.vidyo.model;

public class SearchFilter {

	public SearchFilter(EntityType type){
		this.entityType = type.toString();
	}
	
	public SearchFilter(EntityType type, int start, int limit){
		this.entityType = type.toString();
		this.start = start;
		this.limit = limit;
	}
	
	public enum SortBy {
		member,
		name,
		extension
	}
	
	public enum Dir {
		ASC,
		DESC
	}
	
	public enum EntityType {
		Member,
		Room,
		Legacy
	}
	
    public int getStart() {
		return start;
	}
    
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public String getSortBy() {
		return sortBy;
	}
	
	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy.toString();
	}
	
	public String getDir() {
		return dir;
	}
	
	public void setDir(Dir dir) {
		this.dir = dir.toString();
	}
	
	public String getEntityType() {
		return entityType;
	}
	
	public void setEntityType(EntityType type) {
		this.entityType = type.toString();
	}

	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	private int start;
    private int limit;
    private String sortBy; 			// member name extension
    private String dir; 			// ASC DESC
    private String entityType; 		// Member Room Legacy  **
    private String query;
}
