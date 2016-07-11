package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPEASSIGNMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Typeassignment.findAll", query="SELECT t FROM Typeassignment t")
public class Typeassignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@SequenceGenerator(name="TYPEASSIGNMENT_TYPE_GENERATOR", sequenceName="TYPEASSIGNMENT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPEASSIGNMENT_TYPE_GENERATOR")*/
	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to Studentca
	@OneToMany(mappedBy="typeassignment")
	private List<Studentca> studentcas;

	public Typeassignment() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Studentca> getStudentcas() {
		return this.studentcas;
	}

	public void setStudentcas(List<Studentca> studentcas) {
		this.studentcas = studentcas;
	}

	public Studentca addStudentca(Studentca studentca) {
		getStudentcas().add(studentca);
		studentca.setTypeassignment(this);

		return studentca;
	}

	public Studentca removeStudentca(Studentca studentca) {
		getStudentcas().remove(studentca);
		studentca.setTypeassignment(null);

		return studentca;
	}

}