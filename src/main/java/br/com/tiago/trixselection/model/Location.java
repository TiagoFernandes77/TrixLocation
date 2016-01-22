package br.com.tiago.trixselection.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Location implements Serializable{

	private static final long serialVersionUID = -6962160194289837188L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private Date created;
	
	private double latitude;
	
	private double longitude;
	
	@ManyToMany
	@JoinTable(name="LocationTag",
		joinColumns= {@JoinColumn(name="location_id")},
		inverseJoinColumns= {@JoinColumn(name="tag_id")})
	private List<Tag> tags;
	
	public Location(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public void setTag(Tag tag){
		if(tags == null){
			tags = new ArrayList<Tag>();
		}
		
		tags.add(tag);
	}
}
