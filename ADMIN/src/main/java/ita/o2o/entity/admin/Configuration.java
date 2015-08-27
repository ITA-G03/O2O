package ita.o2o.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ADMIN_CONFIG")
public class Configuration {
	@Id
	@SequenceGenerator(sequenceName = "SEQ_ADMIN_CONFIG", name = "configSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configSequence")
	@Column(name = "CONFIG_ID", nullable = false)
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CONFIGVALUE")
	private String value;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
