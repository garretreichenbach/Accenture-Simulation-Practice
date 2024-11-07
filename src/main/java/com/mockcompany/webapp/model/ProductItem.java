package com.mockcompany.webapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ProductItem {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Integer cost;
	@Lob
	@Column(nullable = false)
	private String image;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		ProductItem that = (ProductItem) o;
		return Objects.equals(name, that.name)
				&& Objects.equals(description, that.description)
				&& Objects.equals(cost, that.cost)
				&& Objects.equals(image, that.image);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, cost, image);
	}

	@Override
	public String toString() {
		return "ProductItem{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", cost=" + cost +
				", image='" + image + '\'' +
				'}';
	}
}
