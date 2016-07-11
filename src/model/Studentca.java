package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the STUDENTCA database table.
 * 
 */
@Entity
@NamedQuery(name="Studentca.findAll", query="SELECT s FROM Studentca s")
public class Studentca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDENTCA_ID_GENERATOR", sequenceName="STUDENTCA_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENTCA_ID_GENERATOR")
	private long id;

	@Temporal(TemporalType.DATE)
	private Date assdate;

	@Column(name="ASSIGNMENT_NAME")
	private String assignmentName;

	private BigDecimal grade;

	@Column(name="STUDENT_ID")
	private BigDecimal studentId;


	//bi-directional many-to-one association to Typeassignment
	@ManyToOne
	@JoinColumn(name="TYPE")
	private Typeassignment typeassignment;

	public Studentca() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAssdate() {
		return this.assdate;
	}

	public void setAssdate(Date assdate) {
		this.assdate = assdate;
	}

	public String getAssignmentName() {
		return this.assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public BigDecimal getStudentId() {
		return this.studentId;
	}

	public void setStudentId(BigDecimal studentId) {
		this.studentId = studentId;
	}

	public Typeassignment getTypeassignment() {
		return this.typeassignment;
	}

	public void setTypeassignment(Typeassignment typeassignment) {
		this.typeassignment = typeassignment;
	}

}